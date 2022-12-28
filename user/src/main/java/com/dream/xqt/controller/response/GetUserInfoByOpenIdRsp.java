package com.dream.xqt.controller.response;

import lombok.Data;

/**
 * @author xinxiaoyao
 * @date 2022/11/6 12:45
 */
@Data
public class GetUserInfoByOpenIdRsp {
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
