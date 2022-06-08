package com.young.zrszt.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/19 18:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("浏览历史")
public class BrowseHistory {

    @ApiModelProperty("浏览历史ID")
    private Long id;

}
