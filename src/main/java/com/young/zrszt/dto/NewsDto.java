package com.young.zrszt.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/31 16:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("新闻数据传输对象")
public class NewsDto {

    @ApiModelProperty("新闻ID")
    private Long id;

    @ApiModelProperty("新闻标题")
    private String title;

    @ApiModelProperty("公司名称")
    private String company;

    @ApiModelProperty("封面图")
    private String coverImage;

    @ApiModelProperty("媒体名称")
    private String media;

    @ApiModelProperty("发布时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date releaseTime;

    @ApiModelProperty("新闻内容")
    private String content;

    @ApiModelProperty("新闻源")
    private String sourceUrl;

    @ApiModelProperty("新闻附件源")
    private String fileUrl;

    @ApiModelProperty("收藏ID, 收藏展示字段并显示收藏ID，未收藏字段不展示")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long collectId;
}
