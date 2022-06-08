package com.young.zrszt.enums;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author error-codes【BayMax】
 * @description
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/6/4 22:15
 */
@Getter
@AllArgsConstructor
@ApiModel("时间")
public enum DateKind {

    @ApiModelProperty("近一月")
    ONE_MONTH(0),

    @ApiModelProperty("近三月")
    THREE_MONTH(1),

    @ApiModelProperty("近半年")
    HALF_YEAR(2),

    @ApiModelProperty("近两年")
    TWO_YEAR(3),

    @ApiModelProperty("近三年")
    THREE_YEAR(4);

    private final Integer date;
}
