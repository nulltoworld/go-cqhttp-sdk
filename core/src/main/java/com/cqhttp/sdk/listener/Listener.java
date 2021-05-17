package com.cqhttp.sdk.listener;

/**
 * 监听器
 *
 * @param <T>
 */
public interface Listener<T> {

    /**
     * 监听到消息
     *
     * @param t 消息实体
     */
    void onMessage(T t);

    /**
     * 验证方法 在onMessage前调用，返回false时不调用onMessage
     *
     * @param t 消息实体
     * @return 返回true时调用onMessage 否则跳过
     */
    default Boolean valider(T t) {
        return true;
    }

    /**
     * 是否开启该监听器 返回true时开启
     *
     * @return
     */
    default Boolean enable() {
        return false;
    }
}
