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
public class CommonDataResult<T> extends CommonResult {

    /**
     * 数据
     */
    private T result;

    public CommonDataResult(Integer success, String message, T result) {
        super(success, message);
        this.result = result;
    }
}
