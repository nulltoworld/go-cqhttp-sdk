package com.cqhttp.sdk.client;

import com.cqhttp.sdk.client.impl.*;
import com.cqhttp.sdk.config.CQConfig;

/**
 * 封装了客户端生成方法
 */
public class ClientFactory {
    private CQConfig config;

    public ClientFactory(CQConfig config) {
        this.config = config;
    }

    public AdminClient createAdminClient() {
        return new AdminClient(config);
    }

    public GroupClient createGroupClient() {
        return new GroupClient(config);
    }

    public MessageClient createMessageClient() {
        return new MessageClient(config);
    }

    public UserClient createUserClient() {
        return new UserClient(config);
    }

    public GroupAdminClient createGroupAdminClient() {
        return new GroupAdminClient(config);
    }

    public FileClient createGroupFileClient() {
        return new FileClient(config);
    }

    public void setConfig(CQConfig config) {
        this.config = config;
    }

    public CQConfig getConfig() {
        return config;
    }

}
