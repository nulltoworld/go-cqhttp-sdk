package com.cqhttp.sdk.listener.impl;

import com.cqhttp.sdk.event.message.GroupMessage;
import com.cqhttp.sdk.event.message.PrivateMessage;
import com.cqhttp.sdk.listener.HandlerListener;
import com.cqhttp.sdk.listener.handler.Handler;

public class PrivateMessageListener extends HandlerListener<PrivateMessage> {

    @Override
    public void onMessage(PrivateMessage privateMessage) {
        //处理逻辑
        String message = privateMessage.getMessage();
        String[] split = message.split(" ");
        String key = split[0];
        Handler<PrivateMessage> handler = getHandler(key);
        if (handler != null) {
            handler.handle(privateMessage);
        }
    }
}
