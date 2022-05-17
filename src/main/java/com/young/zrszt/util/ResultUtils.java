package com.young.zrszt.util;

import com.young.zrszt.common.CommonDataResult;
import com.young.zrszt.common.CommonResult;
import com.young.zrszt.common.ResultCode;
import com.young.zrszt.common.ResultMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/12 23:29
 */
public class ResultUtils {

    /*********************************************
     *                                           *
     *                200_结果集                  *
     *                                           *
     ********************************************/
    public static <T> CommonDataResult<T> success(T data) {
        return success(ResultMessage.SUCCESS, data);
    }

    public static <T> CommonDataResult<T> success(String message, T data) {
        return new CommonDataResult<T>(ResultCode.SUCCESS, message, data);
    }

    public static CommonResult success(String message) {
        return new CommonResult(ResultCode.SUCCESS, message);
    }


    /*********************************************
     *                                           *
     *                401_结果集                  *
     *                                           *
     ********************************************/
    public static <T> CommonDataResult<T> unauthorized(T data) {
        return unauthorized(ResultMessage.UNAUTHORIZED, data);
    }

    public static <T> CommonDataResult<T> unauthorized(String message, T data) {
        return new CommonDataResult<T>(ResultCode.UNAUTHORIZED, message, data);
    }

    public static CommonResult unauthorized(String message) {
        return new CommonResult(ResultCode.UNAUTHORIZED, message);
    }


    /*********************************************
     *                                           *
     *                403_结果集                  *
     *                                           *
     ********************************************/
    public static <T> CommonDataResult<T> forbidden(T data) {
        return forbidden(ResultMessage.FORBIDDEN, data);
    }

    public static <T> CommonDataResult<T> forbidden(String message, T data) {
        return new CommonDataResult<T>(ResultCode.FORBIDDEN, message, data);
    }

    public static CommonResult forbidden(String message) {
        return new CommonResult(ResultCode.FORBIDDEN, message);
    }


    /*********************************************
     *                                           *
     *                404_结果集                  *
     *                                           *
     ********************************************/
    public static <T> CommonDataResult<T> error(T data) {
        return error(ResultMessage.VALIDATE_FAILED, data);
    }

    public static <T> CommonDataResult<T> error(String message, T data) {
        return new CommonDataResult<T>(ResultCode.VALIDATE_FAILED, message, data);
    }

    public static CommonResult error(String message) {
        return new CommonResult(ResultCode.VALIDATE_FAILED, message);
    }


    /*********************************************
     *                                           *
     *                500_结果集                  *
     *                                           *
     ********************************************/
    public static <T> CommonDataResult<T> failed(T data) {
        return failed(ResultMessage.FAILED, data);
    }

    public static <T> CommonDataResult<T> failed(String message, T data) {
        return new CommonDataResult<T>(ResultCode.FAILED, message, data);
    }

    public static CommonResult failed(String message) {
        return new CommonResult(ResultCode.FAILED, message);
    }


    /*********************************************
     *                                           *
     *                400_结果集                  *
     *                                           *
     ********************************************/
    public static <T> CommonDataResult<T> userError(T data) {
        return userError(ResultMessage.USER_INPUT_ERROR, data);
    }

    public static <T> CommonDataResult<T> userError(String message, T data) {
        return new CommonDataResult<T>(ResultCode.USER_INPUT_ERROR, message, data);
    }

    public static CommonResult userError(String message) {
        return new CommonResult(ResultCode.USER_INPUT_ERROR, message);
    }


    /*********************************************
     *                                           *
     *                520_结果集                  *
     *                                           *
     ********************************************/
    public static <T> CommonDataResult<T> systemError(T data) {
        return systemError(ResultMessage.SYSTEM_ERROR, data);
    }

    public static <T> CommonDataResult<T> systemError(String message, T data) {
        return new CommonDataResult<T>(ResultCode.SYSTEM_ERROR, message, data);
    }

    public static CommonResult systemError(String message) {
        return new CommonResult(ResultCode.SYSTEM_ERROR, message);
    }

}
