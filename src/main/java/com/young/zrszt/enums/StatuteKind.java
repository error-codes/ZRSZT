package com.young.zrszt.enums;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/24 18:39
 */
@Getter
@AllArgsConstructor
@ApiModel("法规种类")
public enum StatuteKind {

    TEST(0);

    private final Integer kind;
}
