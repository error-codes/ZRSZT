package com.young.zrszt.vo;

import com.young.zrszt.enums.Category;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/19 17:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("收藏视图对象")
public class CollectVo {

    @ApiModelProperty(value = "收藏实体ID")
    @NotNull(message = "收藏实体ID不能为空")
    private Long entityId;

    @ApiModelProperty(value = "用户ID")
    @NotNull(message = "用户ID不能为空")
    private Long userId;

    @ApiModelProperty(value = "实体类别")
    @NotNull(message = "实体类别不能为空")
    private Category category;

}
