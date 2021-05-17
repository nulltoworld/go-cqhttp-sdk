package com.cqhttp.sdk.listener;

public abstract class EnableListener<T> implements Listener<T>  {

    private Boolean enable = true;//默认开启

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Boolean getEnable() {
        return enable;
    }

    @Override
    public Boolean enable() {
        return enable;
    }
}
