package com.dream.xqt.common.exceptions;

/**
 * @author xinxiaoyao
 * @date 2022/5/18 18:03
 */
public class BizException extends RuntimeException {
    private String code;
    private final Object data;
    private final IBizException vo;
    private String message;

    public BizException(IBizException vo) {
        super(vo.getMessage(), vo.getCause());
        this.vo = vo;
        this.code = vo.getCode();
        this.data = vo.getData();
    }

    public BizException(String code, String message) {
        super(message);
        this.code = code;
        this.data = null;
        this.vo = null;
    }

    public BizException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.data = null;
        this.vo = null;
    }

    public BizException(String code, String message, Object data) {
        super(message);
        this.code = code;
        this.data = data;
        this.vo = null;
    }

    public BizException(String code, String message, Object data, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.data = data;
        this.vo = null;
    }

    public String getMessage() {
        return this.message != null && !this.message.isEmpty() ? this.message : super.getMessage();
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return this.data;
    }

    public IBizException getVo() {
        return this.vo;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

