package com.dream.xqt.common.exceptions;

/**
 * @author xinxiaoyao
 * @date 2022/5/18 17:59
 */
public interface IBizException {
    String getCode();

    String getMessage();

    Object getData();

    Throwable getCause();
}