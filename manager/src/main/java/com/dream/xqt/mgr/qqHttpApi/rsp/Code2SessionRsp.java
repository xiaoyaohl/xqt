package com.dream.xqt.mgr.qqHttpApi.rsp;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xinxiaoyao
 * @date 2022/7/25 19:25
 */
@Data
public class Code2SessionRsp implements Serializable {
    private static final long serialVersionUID = -6496805240751143641L;

    /**
     * 用户唯一标识
     */
    private String openid;

    /**
     * 会话密钥
     */
    private String session_key;

    /**
     * 用户在开放平台的唯一标识符，在满足 UnionID 下发条件的情况下会返回
     */
    private String unionid;

    /**
     * 错误码
     */
    private Integer errcode;

    /**
     * 错误信息
     */
    private String errmsg;
}
