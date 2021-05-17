package test.client;

import com.cqhttp.sdk.client.ClientFactory;
import com.cqhttp.sdk.client.impl.MessageClient;
import com.cqhttp.sdk.client.response.CQFile;
import com.cqhttp.sdk.client.response.ForwardMessage;
import com.cqhttp.sdk.client.response.ForwardNode;
import com.cqhttp.sdk.client.response.Message;
import com.cqhttp.sdk.config.CQConfig;
import org.junit.Test;
import test.TestApplication;

import java.util.ArrayList;
import java.util.List;


public class MessaggeClientTest {

    private MessageClient client =  new ClientFactory(TestApplication.http_config).createMessageClient();

    /**
     * 发送私聊消息
     */
    @Test
    public void sendPrivateMsg() {
        Integer messageId = client.sendPrivateMsg(1452683658L, "你好 哈哈哈");
        System.out.println(messageId);
    }

    /**
     * 发送群聊消息
     */
    @Test
    public void sendGroupMsg() {
        Integer messageId =  client.sendGroupMsg(934145943L, "你好 哈哈哈");
        System.out.println(messageId);
    }

    /**
     * 发送群聊消息 失败
     */
    @Test
    public void sendGrouForwardMsg() {
        ForwardNode forwardNode = new ForwardNode();
        ForwardNode.Data data = forwardNode.getData();
        data.setName("slcower");
        data.setContent("消息");
        data.setSeq("消息");
        data.setId(1720939235);
        data.setUin(1452683658L);
        ArrayList<ForwardNode> nodes = new ArrayList();
        nodes.add(forwardNode);
        nodes.add(forwardNode);
        client.sendGroupForwardMsg(934145943L, nodes);
    }


    /**
     * 获取消息
     */
    @Test
    public void getMsg() {
        Message msg = client.getMsg(-1319087279);
        System.out.println(msg);
    }

    /**
     * 获取转发消息
     */
    @Test
    public void getForwardMsg() {
        List<ForwardMessage> msg = client.getForwardMsg("UCo26UaLLOtG8dqEksKI3NyPQimtBqzSSFo2evjHq6OolzLLeioJOmkroXzMo14Z");
        System.out.println(msg);
    }

    /**
     * 获取图片缓存
     */
    @Test
    public void getImage() {
        CQFile msg = client.getImage("b9af9aae1925d85bbd1503a874b130fe.image");
        System.out.println(msg);
    }

    /**
     * 撤回消息
     */
    @Test
    public void deleteMsg() {
        client.deleteMsg( client.sendGroupMsg(934145943L, "你好 哈哈哈"));
    }

}
