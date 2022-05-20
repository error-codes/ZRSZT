package com.young.zrszt;

import com.young.zrszt.common.CommonResult;
import com.young.zrszt.util.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/17 15:57
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 缺少必要的参数
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public CommonResult missingParameterHandler(HttpServletRequest request, MissingServletRequestParameterException e) {
        this.logError(request, e);
        return ResultUtils.response(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    /**
     * 参数类型不匹配
     */
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public CommonResult methodArgumentTypeMismatchException(HttpServletRequest request, MethodArgumentTypeMismatchException e) {
        this.logError(request, e);
        return ResultUtils.response(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    /**
     * 不支持的请求方法
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public CommonResult httpRequestMethodNotSupportedException(HttpServletRequest request, HttpRequestMethodNotSupportedException e) {
        this.logError(request, e);
        return ResultUtils.response(HttpStatus.METHOD_NOT_ALLOWED.value(), e.getMessage());
    }

    /**
     * 参数错误
     */
    @ExceptionHandler(value = IllegalArgumentException.class)
    public CommonResult illegalArgumentException(HttpServletRequest request, IllegalArgumentException e) {
        this.logError(request, e);
        return ResultUtils.response(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    /**
     * 其他异常统一处理
     */
    @ExceptionHandler(value = Exception.class)
    public CommonResult exception(HttpServletRequest request, Exception e) {
        this.logError(request, e);
        return ResultUtils.response(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

    /**
     * 记录错误日志
     */
    private void logError(HttpServletRequest request, Exception e) {
        log.error("path:{}, queryParam:{}, errorMessage:{}", request.getRequestURI(), request.getQueryString(), e.getMessage(), e);
    }

}
