package test.client;

import com.cqhttp.sdk.client.ClientFactory;
import com.cqhttp.sdk.client.impl.GroupAdminClient;
import com.cqhttp.sdk.client.impl.MessageClient;
import com.cqhttp.sdk.client.response.*;
import com.cqhttp.sdk.config.CQConfig;
import org.junit.Test;
import test.TestApplication;

import java.util.ArrayList;
import java.util.List;


public class GroupAdminClientTest {

    private GroupAdminClient client = new ClientFactory(TestApplication.http_config).createGroupAdminClient();

    /**
     * 移出群聊
     */
    @Test
    public void setGroupKick() {
        client.setGroupKick(934145943L, 3211341882L);
    }

    /**
     * 禁言
     */
    @Test
    public void setGroupBan() {
        client.setGroupBan(934145943L, 3211341882L, 1000L);
    }

    /**
     * 取消禁言
     */
    @Test
    public void removeGroupBan() {
        client.removeGroupBan(934145943L, 3211341882L);
    }


    /**
     * 匿名禁言
     */
    @Test
    public void setGroupAnonymousBan() {
        client.setGroupAnonymousBan(934145943L, "KhzkTUEv9euiSpb0Wy7JlL+FgpoGTbIO2JPqfR73DfGWwT0n91f92w==|黑旋风", 1000L);
    }

    /**
     * 全体禁言
     */
    @Test
    public void startGroupWholeBan() {
        client.startGroupWholeBan(934145943L);
        client.closeGroupWholeBan(934145943L);
    }

    /**
     * 增加群管理
     */
    @Test
    public void addGroupAdmin() {
        client.addGroupAdmin(823079847L, 256211295L);
        client.removeGroupAdmin(934145943L, 1452683658L);
    }

    /**
     * 设置群名片
     */
    @Test
    public void setGroupCard() {
        client.setGroupCard(934145943L, 3211341882L,"你几把谁啊");
        client.removeGroupCard(934145943L, 3211341882L);
    }

    /**
     * 解散群组
     */
    @Test
    public void setGroupLeave() {
        client.setGroupLeave(934145943L);
    }

    /**
     * 设置群名
     */
    @Test
    public void setGroupName() {
        client.setGroupName(934145943L,"什么群啊");
    }

    /**
     *  自定义头衔
     */
    @Test
    public void setGroupSpecialTitle() {
        client.setGroupSpecialTitle(934145943L,1452683658L,"什么");
        client.removeGroupSpecialTitle(934145943L,1452683658L);
    }

    /**
     * 设置群头像
     */
    @Test
    public void setGroupPortrait(){
        client.setGroupPortrait(934145943L,"https://img2.woyaogexing.com/2021/05/11/36710098accf4f81afb73c184489e582!400x400.jpeg",1);
    }

    /**
     * 获取剩余@全体次数
     */
    @Test
    public void getGroupAtAllRemain(){
        GroupAtAllRemain groupAtAllRemain = client.getGroupAtAllRemain(934145943L);
        System.out.println(groupAtAllRemain);
    }

    /**
     * 发送群公告
     */
    @Test
    public void sendGroupNotice(){
        client.sendGroupNotice(934145943L,"测试");
    }

    /**
     * 设置精华消息
     */
    @Test
    public void setEssenceMsg(){
        client.setEssenceMsg(1026780546);
    }

    /**
     * 获取精华消息列表
     */
    @Test
    public void getEssenceMsgList(){
        List<EssenceMsg> msgList = client.getEssenceMsgList(934145943L);
        System.out.println(msgList);
    }

    /**
     * 移除精华消息
     */
    @Test
    public void deleteEssenceMsg(){
        client.deleteEssenceMsg(1026780546);
    }
}
