package com.young.zrszt.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/12 23:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult {

    /**
     * 状态码
     */
    private Integer statusCode;

    /**
     * 响应信息
     */
    private String message;
}
