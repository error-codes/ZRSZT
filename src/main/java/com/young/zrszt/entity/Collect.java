package com.young.zrszt.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/19 16:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("收藏")
public class Collect {

    @ApiModelProperty("收藏ID")
    private Long collectId;

    @ApiModelProperty("实体ID")
    private Long entityId;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("收藏时间")
    private Date collectTime;

    @ApiModelProperty("实体类别")
    private Integer category;
}
