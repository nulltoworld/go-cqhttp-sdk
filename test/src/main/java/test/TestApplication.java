package test;

import com.cqhttp.sdk.config.CQConfig;
import com.cqhttp.sdk.connection.Connection;
import com.cqhttp.sdk.connection.ConnectionFactory;
import com.cqhttp.sdk.event.EventDispatchers;
import com.cqhttp.sdk.event.message.GroupMessage;
import com.cqhttp.sdk.event.message.PrivateMessage;
import com.cqhttp.sdk.listener.SimpleListener;
import com.cqhttp.sdk.listener.handler.Handler;
import com.cqhttp.sdk.listener.impl.GroupMessageListener;

import java.util.concurrent.LinkedBlockingQueue;


public class TestApplication {

    public static CQConfig config = new CQConfig("ws://ip:6700", "token", true);
    public static CQConfig http_config = new CQConfig("http://ip:5700", "token", true);


    public static void main(String[] args) throws Exception {
        LinkedBlockingQueue<String> blockingQueue = new LinkedBlockingQueue();//使用队列传输数据
        Connection connection = ConnectionFactory.createWebsocketClient(config, blockingQueue);//使用正向websocket
        //Connection connection = ConnectionFactory.createWebsocketServer(8080, blockingQueue);//使用反向websocket
        connection.create();
        EventDispatchers dispatchers = new EventDispatchers(blockingQueue);//创建事件分发器
        GroupMessageListener groupMessageListener = new GroupMessageListener();
        groupMessageListener.addHandler("天气", new Handler<GroupMessage>() {
            @Override
            public void handle(GroupMessage groupMessage) {
                System.out.println(groupMessage);
            }
        });
        dispatchers.addListener(groupMessageListener);
        dispatchers.addListener(new SimpleListener<PrivateMessage>() {//私聊监听
            @Override
            public void onMessage(PrivateMessage privateMessage) {
                System.out.println(privateMessage);
            }
        });

        dispatchers.start(10);//线程组处理任务

    }
}

