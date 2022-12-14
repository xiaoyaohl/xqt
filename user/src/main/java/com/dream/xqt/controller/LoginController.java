package com.dream.xqt.controller;

import com.alibaba.fastjson.JSON;
import com.dream.xqt.bo.LoginBO;
import com.dream.xqt.common.request.SoaRequest;
import com.dream.xqt.common.response.SoaResponse;
import com.dream.xqt.common.utils.SoaResponseUtil;
import com.dream.xqt.controller.request.GetUserInfoByOpenIdReq;
import com.dream.xqt.controller.request.QQLoginReq;
import com.dream.xqt.controller.response.QQLoginRsp;
import com.dream.xqt.service.impl.LoginServiceImpl;
import com.dream.xqt.vo.LoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author xinxiaoyao
 * @date 2022/7/17 12:45
 */
@RequestMapping("/xqt/api/v1")
@RestController
@Slf4j
public class LoginController {
    @Autowired
    private LoginServiceImpl loginService;

    @PostMapping("/login")
    public SoaResponse<QQLoginRsp, Void> login(@RequestBody @Validated SoaRequest<QQLoginReq> request) {
        QQLoginReq data = request.getData();
        log.info("LoginController.login req >>>>>>>> {}", JSON.toJSONString(data));
        LoginBO loginBO = LoginBO.builder()
                .code(data.getCode())
                .faceImg(data.getFaceImg())
                .nickName(data.getNickName())
                .build();

        LoginVO loginVO = loginService.code2Session(loginBO);

        QQLoginRsp response = QQLoginRsp.builder()
                .userId(loginVO.getUserId())
                .qqOpenId(loginVO.getOpenId())
                .qqUnionId(loginVO.getUnionId())
                .build();

        return SoaResponseUtil.success(response);
    }

}
