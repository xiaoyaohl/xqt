package com.dream.xqt.enums;

/**
 * @author xinxiaoyao
 * @date 2022/7/26 22:26
 */
public enum QQReturnCodeEnum {
    SYSTEM_ERROR(-1,  "系统繁忙"),
    SUCCESS(0, "请求成功"),
    ;

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 描述
     */
    private final String msg;

    QQReturnCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
