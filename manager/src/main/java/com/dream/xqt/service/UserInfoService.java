package com.dream.xqt.service;

import com.dream.xqt.bo.UserInfoBO;
import com.dream.xqt.vo.UserInfoVO;

/**
 * @author xinxiaoyao
 * @date 2022/11/6 12:47
 */
public interface UserInfoService {
    UserInfoVO getUserInfoByOpenId(UserInfoBO userInfoBO);
}
