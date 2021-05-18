package com.cqhttp.sdk.listener.impl;

import com.cqhttp.sdk.event.message.PrivateMessage;
import com.cqhttp.sdk.listener.DefaultHandlerListener;
import com.cqhttp.sdk.listener.handler.Handler;

public class PrivateMessageListener extends DefaultHandlerListener<PrivateMessage> {

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
