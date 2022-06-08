package com.young.zrszt.enums;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author error-codes【BayMax】
 * @description
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/6/4 22:33
 */
@Getter
@AllArgsConstructor
@ApiModel("行业")
public enum Industry {


    NONG_LIN_MU_YU(0);

    private final Integer industry;
}
