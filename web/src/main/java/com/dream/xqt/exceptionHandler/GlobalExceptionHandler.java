package com.dream.xqt.exceptionHandler;

import com.dream.xqt.common.enums.ReturnCodeEnum;
import com.dream.xqt.common.exceptions.BizException;
import com.dream.xqt.common.response.SoaResponse;
import com.dream.xqt.common.utils.SoaResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xinxiaoyao
 * @date 2022/8/16 19:52
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 处理所有不可知的异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    SoaResponse<Void, Void> handleException(Exception e){
        log.error(e.getMessage(), e);
        return SoaResponseUtil.error(ReturnCodeEnum.SYSTEM_ERROR.getCode(), e.getMessage());
    }

    /**
     * 处理所有业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(BizException.class)
    @ResponseBody
    SoaResponse<Void, Void> handleException(BizException e){
        log.error(e.getMessage(), e);
        return SoaResponseUtil.error(e.getCode(), e.getMessage());
    }
}
