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
@ApiModel("国标计划")
public enum Drafter {

    ALL(0),

    DRAFT(1),

    SOLICIT(2),

    APPROVE(3),

    TERMINATE(4);

    private final Integer drafter;
}
