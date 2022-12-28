package com.dream.xqt.controller.response;

import lombok.Builder;
import lombok.Data;

/**
 * @author xinxiaoyao
 * @date 2022/7/23 14:50
 */
@Data
@Builder
public class QQLoginRsp {
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户QQ openId
     */
    private String qqOpenId;

    /**
     * 用户unionId
     */
    private String qqUnionId;

}
