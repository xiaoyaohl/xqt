package com.dream.xqt.common.constant;

/**
 * @author xinxiaoyao
 * @date 2022/7/26 20:23
 */
public interface HttpClientConfig {
    //http连接超时时间
    public Integer CONNECTION_TIMEOUT = 3000;

    //get请求超时时间
    public Integer GET_TIMEOUT = 3000;

    //post请求超时时间
    public Integer POST_TIMEOUT = 3000;
}
