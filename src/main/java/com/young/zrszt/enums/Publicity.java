package com.young.zrszt.enums;

import io.swagger.annotations.ApiModel;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author error-codes【BayMax】
 * @description
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/6/4 22:48
 */
@Getter
@AllArgsConstructor
@ApiModel("拟立项总体分布")
public enum Publicity {

    ALL(0),

    NOW_PUBLICITY(1),

    END_PUBLICITY(2);

    private final Integer publicity;
}
