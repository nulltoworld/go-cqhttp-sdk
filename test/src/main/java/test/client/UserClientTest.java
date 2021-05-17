package test.client;

import com.cqhttp.sdk.client.ClientFactory;
import com.cqhttp.sdk.client.impl.UserClient;
import com.cqhttp.sdk.client.response.Friend;
import com.cqhttp.sdk.client.response.StrangerInfo;
import com.cqhttp.sdk.client.response.VipInfo;
import org.junit.Test;
import test.TestApplication;

import java.util.List;

public class UserClientTest {

    private UserClient client =  new ClientFactory(TestApplication.http_config).createUserClient();


    /**
     * 处理好友申请
     */
    @Test
    public void setFriendAddRequest() {
        client.setFriendAddRequest("1620749609000000", true, "a");
    }

    /**
     * 处理群申请
     */
    @Test
    public void setGroupAddRequest() {
        client.setGroupAddRequest("1620750297560842", "add", true);
    }

    /**
     * 获取陌生人信息
     */
    @Test
    public void getStrangerInfo() {
        StrangerInfo strangerInfo = client.getStrangerInfo(934145943L);
        System.out.println(strangerInfo);
    }

    /**
     * 获取好友列表
     */
    @Test
    public void getFriendList() {
        List<Friend> friendList = client.getFriendList();
        System.out.println(friendList);
    }

    /**
     * 获取vip信息
     */
    @Test
    public void getVipInfo() {
        VipInfo vipInfo = client.getVipInfo(2364893782L);
        System.out.println(vipInfo);
    }
}
