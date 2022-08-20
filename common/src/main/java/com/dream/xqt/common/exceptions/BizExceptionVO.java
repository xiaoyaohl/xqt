package com.dream.xqt.common.exceptions;

import java.io.Serializable;

/**
 * @author xinxiaoyao
 * @date 2022/5/18 18:01
 */
public class BizExceptionVO implements IBizException, Serializable {
    private static final long serialVersionUID = 3813093239155736453L;
    private String code;
    private String message;
    private Object data;
    private Throwable cause;

    public BizExceptionVO(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public BizExceptionVO(String code, String message, Throwable cause) {
        this.code = code;
        this.message = message;
        this.cause = cause;
    }

    public BizExceptionVO(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BizExceptionVO(String code, String message, Object data, Throwable cause) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.cause = cause;
    }

    public static BizExceptionVO valueOf(String code, String message) {
        return new BizExceptionVO(code, message);
    }

    public static BizExceptionVO valueOf(String code, String message, Throwable cause) {
        return new BizExceptionVO(code, message, cause);
    }

    public static BizExceptionVO valueOf(String code, String message, Object data) {
        return new BizExceptionVO(code, message, data);
    }

    public static BizExceptionVO valueOf(String code, String message, Object data, Throwable cause) {
        return new BizExceptionVO(code, message, data, cause);
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public Object getData() {
        return this.data;
    }

    public Throwable getCause() {
        return this.cause;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BizExceptionVO)) {
            return false;
        } else {
            BizExceptionVO other = (BizExceptionVO)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$code = this.getCode();
                    Object other$code = other.getCode();
                    if (this$code == null) {
                        if (other$code == null) {
                            break label59;
                        }
                    } else if (this$code.equals(other$code)) {
                        break label59;
                    }

                    return false;
                }

                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                Object this$cause = this.getCause();
                Object other$cause = other.getCause();
                if (this$cause == null) {
                    if (other$cause != null) {
                        return false;
                    }
                } else if (!this$cause.equals(other$cause)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof BizExceptionVO;
    }

    public int hashCode() {
        int result = 1;
        Object $code = this.getCode();
        result = result * 59 + ($code == null ? 43 : $code.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        Object $cause = this.getCause();
        result = result * 59 + ($cause == null ? 43 : $cause.hashCode());
        return result;
    }

    public String toString() {
        return "BizExceptionVo(code=" + this.getCode() + ", message=" + this.getMessage() + ", data=" + this.getData() + ", cause=" + this.getCause() + ")";
    }
}

