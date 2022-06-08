package com.young.zrszt.enums;

import io.swagger.annotations.ApiModel;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author error-codes【BayMax】
 * @description
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/6/4 22:44
 */
@Getter
@AllArgsConstructor
@ApiModel("行业领域")
public enum IndustrySector {

    BUILD_MATERIAL(0);

    private final Integer sector;
}
