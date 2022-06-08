package com.young.zrszt.enums;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author error-codes【BayMax】
 * @description
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/6/5 10:54
 */
@Getter
@AllArgsConstructor
@ApiModel("项目状态")
public enum ProjectStatus {

    RELEASE(0),

    IMPLEMENT(1),

    ABOLISH(2);

    private final Integer projectStatus;
}
