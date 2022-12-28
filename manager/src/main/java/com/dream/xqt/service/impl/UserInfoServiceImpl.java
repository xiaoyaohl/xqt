package com.dream.xqt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dream.xqt.DTO.UserInfoDTO;
import com.dream.xqt.bo.UserInfoBO;
import com.dream.xqt.mapper.UniversityInfoMapper;
import com.dream.xqt.mapper.UserInfoMapper;
import com.dream.xqt.service.UserInfoService;
import com.dream.xqt.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xinxiaoyao
 * @date 2022/11/7 11:16
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UniversityInfoMapper universityInfoMapper;

    @Override
    public UserInfoVO getUserInfoByOpenId(UserInfoBO userInfoBO) {

        LambdaQueryWrapper<UserInfoDTO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfoDTO::getQqOpenId, userInfoBO.getOpenId());
        UserInfoDTO userInfoDTO = userInfoMapper.selectOne(queryWrapper);

        return wrapperUserinfoVO(userInfoDTO);
    }

    private UserInfoVO wrapperUserinfoVO(UserInfoDTO userInfoDTO) {
        UserInfoVO userInfoVO = new UserInfoVO();

        userInfoVO.setAge(userInfoDTO.getAge());
        userInfoVO.setAmount(userInfoDTO.getAmount());
        userInfoVO.setFaceImg(userInfoDTO.getFaceImg());
        userInfoVO.setNickName(userInfoDTO.getNickName());
        userInfoVO.setName(userInfoDTO.getName());
        userInfoVO.setOpenId(userInfoDTO.getOpenId());
        userInfoVO.setUnionId(userInfoDTO.getUnionId());
        userInfoVO.setPhone(userInfoDTO.getPhone());
        userInfoVO.setPoint(userInfoDTO.getPoint());
        userInfoVO.setQqOpenId(userInfoDTO.getQqOpenId());
        userInfoVO.setQqUnionId(userInfoDTO.getQqUnionId());
        userInfoVO.setQq(userInfoDTO.getQq());
        userInfoVO.setSex(userInfoDTO.getSex());
        userInfoVO.setStudentId(userInfoDTO.getStudentId());

        return userInfoVO;
    }
}
