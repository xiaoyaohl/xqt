package com.dream.xqt.service;

import com.dream.xqt.bo.LoginBO;
import com.dream.xqt.vo.LoginVO;

/**
 * @author xinxiaoyao
 * @date 2022/7/25 18:59
 */
public interface LoginService {
    /**
     * qq小程序登录登录凭证校验
     * @param loginBO
     * @return
     */
    public LoginVO code2Session(LoginBO loginBO);
}
