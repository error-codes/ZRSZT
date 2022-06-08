package com.young.zrszt.enums;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/19 15:42
 */
@Getter
@AllArgsConstructor
@ApiModel("分类")
public enum Category {

    @ApiModelProperty("新闻")
    NEWS(1),

    @ApiModelProperty("企业")
    COMPANY(2),

    @ApiModelProperty("法规")
    STATUTE(3),

    @ApiModelProperty("标准")
    STANDARD(4);

    private final Integer category;

}
