package com.young.zrszt.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/17 18:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("新闻")
public class News {

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

}
