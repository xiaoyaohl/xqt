package com.dream.xqt.vo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xinxiaoyao
 * @date 2022/7/26 22:12
 */
@Data
@Builder
public class LoginVO implements Serializable {
    private static final long serialVersionUID = -6018958632210680822L;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户openId
     */
    private String openId;

    /**
     * 用户unionId
     */
    private String unionId;
}
