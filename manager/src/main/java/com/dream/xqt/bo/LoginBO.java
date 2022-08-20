package com.dream.xqt.bo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xinxiaoyao
 * @date 2022/7/26 22:12
 */
@Data
@Builder
public class LoginBO implements Serializable {
    private static final long serialVersionUID = 7332229756386772379L;

    /**
     * 登录时获取的code
     */
    private String code;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户头像
     */
    private String faceImg;
}
