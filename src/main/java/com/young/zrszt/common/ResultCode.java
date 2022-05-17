package com.young.zrszt.common;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/12 23:33
 */
public class ResultCode {

    /*********************************************
     *                                           *
     *                默认的状态码                 *
     *                                           *
     ********************************************/
    public static final Integer SUCCESS = 200;
    public static final Integer ERROR = -1;
    public static final Integer UNAUTHORIZED = 401;
    public static final Integer FORBIDDEN = 403;
    public static final Integer VALIDATE_FAILED = 404;
    public static final Integer FAILED = 500;


    /*********************************************
     *                                           *
     *                自定义状态码                 *
     *                                           *
     ********************************************/
    public static final Integer USER_INPUT_ERROR = 400;
    public static final Integer SYSTEM_ERROR = 520;
}
