package com.dream.xqt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dream.xqt.DTO.UserInfoDTO;
import com.dream.xqt.common.enums.ReturnCodeEnum;
import com.dream.xqt.enums.QQReturnCodeEnum;
import com.dream.xqt.bo.LoginBO;
import com.dream.xqt.common.constant.QQMiniAppInfo;
import com.dream.xqt.common.exceptions.BizException;
import com.dream.xqt.enums.UUIDBizTypeEnum;
import com.dream.xqt.mapper.UserInfoMapper;
import com.dream.xqt.mgr.qqHttpApi.QQUserApi;
import com.dream.xqt.mgr.qqHttpApi.req.Code2SessionReq;
import com.dream.xqt.mgr.qqHttpApi.rsp.Code2SessionRsp;
import com.dream.xqt.service.LoginService;
import com.dream.xqt.service.UUIDService;
import com.dream.xqt.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xinxiaoyao
 * @date 2022/7/25 19:01
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private QQUserApi qqUserApi;

    @Autowired
    private UUIDServiceImpl uuidService;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public LoginVO code2Session(LoginBO loginBO) {
        Code2SessionReq req = Code2SessionReq.builder()
                .appId(QQMiniAppInfo.APP_ID)
                .secret(QQMiniAppInfo.APP_SECRET)
                .jsCode(loginBO.getCode())
                .grantType(QQMiniAppInfo.GRANT_TYPE)
                .build();

        Code2SessionRsp code2SessionRsp = qqUserApi.code2Session(req);

        //登录失败
        if (code2SessionRsp == null || !QQReturnCodeEnum.SUCCESS.getCode().equals(code2SessionRsp.getErrcode())) {
            throw new BizException(ReturnCodeEnum.LOGIN_FAIL);
        }

        //登录成功
        //1. 根据openId换取userId
        String openid = code2SessionRsp.getOpenid();
        //2. 如果未得到userId，新用户 生成userId并落库
        LambdaQueryWrapper<UserInfoDTO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfoDTO::getQqOpenId, openid);
        UserInfoDTO userInfoDTO = userInfoMapper.selectOne(queryWrapper);

        if (userInfoDTO == null) {
            userInfoDTO = new UserInfoDTO();
            Long id = uuidService.generateId(UUIDBizTypeEnum.USER_ID.getType());
            userInfoDTO.setId(id);
            userInfoDTO.setQqOpenId(openid);
            userInfoDTO.setQqUnionId(code2SessionRsp.getUnionid());
            userInfoDTO.setFaceImg(loginBO.getFaceImg());
            userInfoDTO.setNickName(loginBO.getNickName());

            userInfoMapper.insert(userInfoDTO);
        }

        //3. 返回
        return LoginVO.builder()
                .userId(userInfoDTO.getId())
                .openId(userInfoDTO.getQqOpenId())
                .unionId(userInfoDTO.getQqUnionId())
                .build();
    }
}
