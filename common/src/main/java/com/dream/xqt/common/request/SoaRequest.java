package com.dream.xqt.common.request;

import java.io.Serializable;

/**
 * @author xinxiaoyao
 * @date 2022/5/18 17:37
 */
public class SoaRequest<T> implements Serializable {
    private static final long serialVersionUID = 2206926867141703859L;
    private String appChannel;

    private T data;

    public String getAppChannel() {
        return appChannel;
    }

    public void setAppChannel(String appChannel) {
        this.appChannel = appChannel;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
