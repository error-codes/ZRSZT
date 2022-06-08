package com.young.zrszt.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/19 16:15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("搜索历史")
public class SearchHistory {

    @ApiModelProperty("搜索历史ID")
    private Long historyId;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("搜索关键词")
    private String keyword;

    @ApiModelProperty("搜索时间")
    private LocalDateTime searchTime;
}
