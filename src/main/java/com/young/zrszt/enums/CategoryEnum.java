package com.young.zrszt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/19 15:42
 */
@Getter
@AllArgsConstructor
public enum CategoryEnum {

    // 要闻
    NEWS(1),

    // 企业
    COMPANY(2),

    // 法规
    STATUTE(3),

    // 标准
    STANDARD(4);

    /**
     * 搜索分类
     */
    private final Integer category;

}
