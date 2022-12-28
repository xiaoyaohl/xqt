package com.dream.xqt.controller.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author xinxiaoyao
 * @date 2022/11/6 12:39
 */
@Data
public class GetUserInfoByOpenIdReq {
    /**
     * openId
     */
    @NotEmpty
    private String openId;
}
