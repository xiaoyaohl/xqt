package com.dream.xqt.controller.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author xinxiaoyao
 * @date 2022/7/17 12:56
 */
@Data
public class QQLoginReq {
    /**
     * 登录时获取的code
     */
    @NotEmpty
    private String code;

    /**
     * 头像
     */
    @NotEmpty
    private String faceImg;

    /**
     * 用户昵称
     */
    @NotEmpty
    private String nickName;
}
