package test.client;

import com.cqhttp.sdk.client.ClientFactory;
import com.cqhttp.sdk.client.impl.AdminClient;
import com.cqhttp.sdk.client.impl.FileClient;
import com.cqhttp.sdk.client.response.GroupFileSystemInfo;
import com.cqhttp.sdk.client.response.GroupFiles;
import com.cqhttp.sdk.config.CQConfig;
import org.junit.Test;
import test.TestApplication;

public class FileClientTest {
    private FileClient client =  new ClientFactory(TestApplication.http_config).createGroupFileClient();

    /**
     * 群文件上传测试
     */
    @Test
    public void uploadGroupFile() {
        String file = client.downloadFile("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1426407813,1052953676&fm=26&gp=0.jpg");
        System.out.println(file);
        client.uploadGroupFile(934145943L, file, "文件");
    }

    /**
     * 获取群文件系统信息
     */
    @Test
    public void getGroupFileSystemInfo() {
        GroupFileSystemInfo systemInfo = client.getGroupFileSystemInfo(934145943L);
        System.out.println(systemInfo);
    }

    /**
     * 获取群根目录文件列表
     */
    @Test
    public void getGroupRootFiles() {
        GroupFiles rootFiles = client.getGroupRootFiles(934145943L);
        System.out.println(rootFiles);
    }

    /**
     * 获取群目录文件列表
     */
    @Test
    public void getGroupFilesByFolder() {
        GroupFiles filesByFolder = client.getGroupFilesByFolder(934145943L, "392ab200-7ffb-4d5f-88fe-75fd9902b42e");
        System.out.println(filesByFolder);
    }

    /**
     * 获取群文件资源链接
     */
    @Test
    public void getGroupFileUrl() {
        String fileUrl = client.getGroupFileUrl(934145943L, "a7d0ce3c-b33b-11eb-b8d5-5452007b897a", 102);
        System.out.println(fileUrl);
    }
}
