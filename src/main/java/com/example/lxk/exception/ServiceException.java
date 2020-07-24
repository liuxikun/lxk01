/**
 * Outsider.com.cn.
 * Copyright (c) 2011-2019 All Rights Reserved.
 */
package com.example.lxk.exception;

import com.example.lxk.enums.ResultEnum;

/**
 * @author outsider
 * @version Id: ServiceException.java, v 0.1 2019/9/29 16:09 outsider Exp $$
 */

public class ServiceException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ResultEnum errorCode;

    /**
     * 获取错误编码
     * @param errorCode 错误编码
     */
    public ServiceException(ResultEnum errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ServiceException(ResultEnum errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    /**
     * 获得异常码信息
     *
     * @return 错误信息
     */
    public ResultEnum getErrorCode() {
        return errorCode;
    }

    @Override
    public final String toString() {
        return getClass().getName() + ":" + errorCode + "[" + getMessage() + "]";
    }
}