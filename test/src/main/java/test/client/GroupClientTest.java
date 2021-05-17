package test.client;

import com.cqhttp.sdk.client.ClientFactory;
import com.cqhttp.sdk.client.impl.GroupClient;
import com.cqhttp.sdk.client.impl.MessageClient;
import com.cqhttp.sdk.client.impl.UserClient;
import com.cqhttp.sdk.client.response.*;
import com.cqhttp.sdk.config.CQConfig;
import com.cqhttp.sdk.event.message.GroupMessage;
import com.cqhttp.sdk.type.HonorType;
import org.junit.Test;
import test.TestApplication;

import java.util.List;

public class GroupClientTest {
    private GroupClient client =  new ClientFactory(TestApplication.http_config).createGroupClient();
    private MessageClient messageClient =  new ClientFactory(TestApplication.http_config).createMessageClient();


    /**
     * 获取群信息
     */
    @Test
    public void getGroupInfo() {
        GroupInfo groupInfo = client.getGroupInfo(954387558L);
        System.out.println(groupInfo);
    }

    /**
     * 获取群列表
     */
    @Test
    public void getGroupList() {
        List<GroupInfo> groupInfos = client.getGroupList();
        System.out.println(groupInfos);
    }

    /**
     * 获取群成员信息
     */
    @Test
    public void getGroupMemberInfo() {
        GroupMemberInfo memberInfo = client.getGroupMemberInfo(934145943L, 3211341882l, true);
        System.out.println(memberInfo);
    }

    /**
     * 获取群成员列表
     */
    @Test
    public void getGroupMemberList() {
        List<GroupMemberInfo> groupMemberList = client.getGroupMemberList(934145943L);
        System.out.println(groupMemberList);
    }

    /**
     * 获取群荣誉
     */
    @Test
    public void getGroupHonorInfo() {
        GroupHonorInfo honorInfo = client.getGroupHonorInfo(934145943L, HonorType.ALL);
        System.out.println(honorInfo);
    }

    /**
     * 获取群系统消息
     */
    @Test
    public void getGroupSystemMsg() {
        GroupSystemMsg groupSystemMsg = client.getGroupSystemMsg();
        System.out.println(groupSystemMsg);
    }

    /**
     * 获取群消息历史记录
     */
    @Test
    public void getGroupMsgHistory() {
        List<GroupMessage> msgHistory = client.getGroupMsgHistory(934145943L);
        System.out.println(msgHistory);
    }

}
