package com.young.zrszt.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/20 10:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("通用ID视图对象")
public class CommonIdVo {

    @ApiModelProperty("主键ID")
    @NotNull(message = "主键ID不能为空")
    private Long id;
}
