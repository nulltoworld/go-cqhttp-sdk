package com.cqhttp.sdk.listener.impl;

import com.cqhttp.sdk.event.message.GroupMessage;
import com.cqhttp.sdk.listener.HandlerListener;
import com.cqhttp.sdk.listener.handler.Handler;

public class GroupMessageListener extends HandlerListener<GroupMessage> {

    @Override
    public void onMessage(GroupMessage groupMessage) {
        //处理逻辑
        String message = groupMessage.getMessage();
        String[] split = message.split(" ");
        String key = split[0];
        Handler<GroupMessage> handler = getHandler(key);
        if (handler != null) {
            handler.handle(groupMessage);
        }
    }
}
