package com.dream.xqt.common.utils;

import com.dream.xqt.common.enums.ReturnCodeEnum;
import com.dream.xqt.common.exceptions.BizException;
import com.dream.xqt.common.response.SoaResponse;

import java.io.Serializable;

/**
 * @author xinxiaoyao
 * @date 2022/5/18 17:52
 */
public class SoaResponseUtil implements Serializable {
    private static final long serialVersionUID = 1458293807061205407L;

    private static String defaultSuccessCode = "000000";

    public static boolean isSuccess(SoaResponse soaResponse) {
        return soaResponse != null && soaResponse.getReturnCode() != null
                && ReturnCodeEnum.SUCCESS.getCode().equals(soaResponse.getReturnCode());
    }

    public static void assertSuccess(SoaResponse soaResponse) {
        if (soaResponse.getReturnCode().equals(ReturnCodeEnum.SUCCESS.getCode())) {
            throw new BizException(soaResponse.getReturnCode(), soaResponse.getReturnMsg());
        }
    }

    public static void assertAll(SoaResponse soaResponse) {
        if (soaResponse == null) {
            throw new BizException(ReturnCodeEnum.NULL_RESPONSE_ERROR);
        }

        assertSuccess(soaResponse);

        if (soaResponse.getResponseVo() == null) {
            throw new BizException(ReturnCodeEnum.NULL_RESPONSE_VO_ERROE);
        }
    }

    public static <T, E> SoaResponse<T, E> success() {
        return success(null);
    }

    public static <T, E> SoaResponse<T, E> success(T returnVo) {
        SoaResponse<T, E> rsp = new SoaResponse();
        rsp.setReturnCode(defaultSuccessCode);
        rsp.setResponseVo(returnVo);
        return rsp;
    }

    public static <T, E> SoaResponse<T, E> error(String code, String msg) {
        SoaResponse<T, E> rsp = new SoaResponse();
        rsp.setReturnCode(code);
        rsp.setReturnMsg(msg);
        return rsp;
    }

    public static <T, E> SoaResponse<T, E> error(BizException e) {
        SoaResponse<T, E> rsp = new SoaResponse();
        rsp.setReturnCode(e.getCode());
        rsp.setReturnMsg(e.getMessage());
        return rsp;
    }
}
