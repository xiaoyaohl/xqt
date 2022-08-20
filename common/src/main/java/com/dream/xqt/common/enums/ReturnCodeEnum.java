package com.dream.xqt.common.enums;

import com.dream.xqt.common.exceptions.IBizException;

/**
 * @author xinxiaoyao
 * @date 2022/5/18 17:44
 */
public enum ReturnCodeEnum implements IBizException {
    SUCCESS("000000", "成功"),

    //QQ相关状态
    LOGIN_FAIL("100000", "登录失败"),
    LOGIN_SUCCESS("100001", "登录成功"),

    NULL_RESPONSE_ERROR("900001", "返回值不能为空"),
    NULL_RESPONSE_VO_ERROE("900002", "返回体不能为空"),
    SYSTEM_ERROR("400000", "系统异常"),
    ;

    /**
     * 状态码
     */
    private String code;

    /**
     * 描述信息
     */
    private String message;

    ReturnCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public Object getData() {
        return null;
    }

    @Override
    public Throwable getCause() {
        return null;
    }
}
