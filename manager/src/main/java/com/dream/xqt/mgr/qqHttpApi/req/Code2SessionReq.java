package com.dream.xqt.mgr.qqHttpApi.req;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xinxiaoyao
 * @date 2022/7/25 19:24
 */
@Data
@Builder
public class Code2SessionReq implements Serializable {
    private static final long serialVersionUID = 4300672442134148830L;
    /**
     * appId
     */
    private String appId;

    /**
     * 密钥
     */
    private String secret;

    /**
     * 登录时获取的code
     */
    private String jsCode;

    /**
     * 授权类型 此处只需填写 authorization_code
     */
    private String grantType;
}
