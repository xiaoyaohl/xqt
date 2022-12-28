package com.dream.xqt.controller;

import com.dream.xqt.common.request.SoaRequest;
import com.dream.xqt.common.response.SoaResponse;
import com.dream.xqt.controller.request.GetUserInfoByOpenIdReq;
import com.dream.xqt.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xinxiaoyao
 * @date 2022/11/7 11:17
 */
@RequestMapping("/xqt/api/v1")
@RestController
@Slf4j
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    //通过openid获取用户信息
    @PostMapping("/getUserInfoByOpenId")
    public SoaResponse<GetUserInfoByOpenIdReq, Void> getUserInfoByOpenId(@RequestBody @Validated SoaRequest<GetUserInfoByOpenIdReq> request) {

        return null;
    }
}
