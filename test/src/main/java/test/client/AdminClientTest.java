package test.client;

import com.cqhttp.sdk.client.ClientFactory;
import com.cqhttp.sdk.client.impl.AdminClient;
import com.cqhttp.sdk.client.response.*;
import org.junit.Test;
import test.TestApplication;

import java.util.List;

public class AdminClientTest {

    private AdminClient client =  new ClientFactory(TestApplication.http_config).createAdminClient();


    /**
     * 获取登录号信息
     */
    @Test
    public void getLoginInfo(){
        LoginInfo loginInfo = client.getLoginInfo();
        System.out.println(loginInfo);
    }


    /**
     * 获取是否可以发送图片
     */
    @Test
    public void canSendImage(){
        Boolean status = client.canSendImage();
        System.out.println(status);
    }


    /**
     * 获取是否可以发送语音
     */
    @Test
    public void canSendRecord(){
        Boolean status = client.canSendRecord();
        System.out.println(status);
    }

    /**
     * 获取版本信息
     */
    @Test
    public void getVersionInfo(){
        CQVersionInfo info = client.getVersionInfo();
        System.out.println(info);
    }

    /**
     * 重启go-cqhttp
     */
    @Test
    public void setRestart(){
        client.setRestart(1000L);
    }

    /**
     * 获取分词
     */
    @Test
    public void getWordSlices(){
        List<String> wordSlices = client.getWordSlices("你好 我是张三 哈哈哈");
        System.out.println(wordSlices);
    }

    /**
     * 获取分词
     */
    @Test
    public void ocrImage(){
        OcrImage image = client.ocrImage("bcc702b0affaa0cd3d90dd475c5abd52.image");
        System.out.println(image);
    }

    /**
     * 获取分词
     */
    @Test
    public void getStatus(){
        CQStatus status = client.getStatus();
        System.out.println(status);
    }

    /**
     * 重载事件过滤器
     */
    @Test
    public void reloadEventFilter(){
       client.reloadEventFilter();
    }

    /**
     * 获取在线列表
     */
    @Test
    public void getOnlineClients(){
        List<OnlineClient> clients = client.getOnlineClients(true);
        System.out.println(clients);
    }

    /**
     * 检查链接安全性
     */
    @Test
    public void checkUrlSafely(){
        Integer integer = client.checkUrlSafely("http://www.baidu.com");
        System.out.println(integer);
    }

}
