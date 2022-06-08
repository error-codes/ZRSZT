package com.young.zrszt.entity;

import com.young.zrszt.enums.StatuteKind;
import com.young.zrszt.enums.StatuteSource;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/24 18:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("法规")
public class Statute {

    @ApiModelProperty("法规ID")
    private Long id;

    @ApiModelProperty("法律标题")
    private String title;

    @ApiModelProperty("法律类型")
    private StatuteKind kind;

    @ApiModelProperty("发布时间")
    private Date releaseTime;

    @ApiModelProperty("制定机关")
    private StatuteSource lawSource;

    @ApiModelProperty("法律内容")
    private String content;
}
