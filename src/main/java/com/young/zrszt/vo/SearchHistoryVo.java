package com.young.zrszt.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author error-codes【BayMax】
 * @description
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/6/4 17:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("搜索历史视图对象")
public class SearchHistoryVo {

    @ApiModelProperty("用户ID")
    @NotNull(message = "用户ID不能为空")
    private Long userId;

    @ApiModelProperty("搜索关键词")
    @NotBlank(message = "搜索关键词不能为空")
    private String keyword;
}
