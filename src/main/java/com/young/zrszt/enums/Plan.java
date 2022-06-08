package com.young.zrszt.enums;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author error-codes【BayMax】
 * @description
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/6/4 22:49
 */
@Getter
@AllArgsConstructor
@ApiModel("国家计划")
public enum Plan {

    ALL(0),

    COMING(1),

    IN_FORCE(2),

    REPLACED(3),

    ABONDON(4);

    private final Integer plan;
}
