package com.dream.xqt.common.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xinxiaoyao
 * @date 2022/5/18 17:31
 */
public class SoaResponse<T, ErrT> implements Serializable {
    private static final long serialVersionUID = 8580731493129893703L;

    private String returnCode = "000000";
    private String returnMsg;
    private String logBizData;
    private Boolean processResult = true;
    private T responseVo;
    private ErrT errT;
    private String timestamp = System.currentTimeMillis() + "";

    public SoaResponse() {
    }

    public Boolean getProcessResult() {
        return this.processResult;
    }

    public void setProcessResult(Boolean processResult) {
        this.processResult = processResult;
    }

    public T getResponseVo() {
        return this.responseVo;
    }

    public void setResponseVo(T responseVo) {
        this.responseVo = responseVo;
    }

    public ErrT getErrT() {
        return this.errT;
    }

    public void setErrT(ErrT errT) {
        this.errT = errT;
    }

    public String getReturnCode() {
        return this.returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return this.returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getLogBizData() {
        return this.logBizData;
    }

    public void setLogBizData(String logBizData) {
        this.logBizData = logBizData;
    }

    public Boolean isSuccessForMornitor() {
        return this.getProcessResult();
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}

