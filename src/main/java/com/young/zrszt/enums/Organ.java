package com.young.zrszt.enums;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author error-codes【BayMax】
 * @description
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/6/4 22:38
 */
@Getter
@AllArgsConstructor
@ApiModel("机关部门")
public enum Organ {

    MIIT(0);

    private final Integer organ;
}
