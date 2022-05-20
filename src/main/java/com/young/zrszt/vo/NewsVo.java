package com.young.zrszt.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/19 15:35
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("新闻视图对象")
public class NewsVo extends CommonIdVo {

    @ApiModelProperty(value = "新闻标题", required = true)
    @NotBlank(message = "新闻标题不能为空")
    private String title;

    @ApiModelProperty("公司名称")
    private String company;

    @ApiModelProperty("封面图片")
    private String coverImage;

    @ApiModelProperty(value = "媒体名称", required = true)
    @NotBlank(message = "媒体名称不能为空")
    private String media;

    @ApiModelProperty(value = "发布时间", required = true)
    @NotNull(message = "发布时间不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date releaseTime;

    @ApiModelProperty(value = "新闻内容", required = true)
    @NotNull(message = "新闻内容不能为空")
    private String content;

    @ApiModelProperty(value = "信息源", required = true)
    @NotNull(message = "信息源不能为空")
    private String sourceUrl;

    @ApiModelProperty(value = "附件地址")
    private String fileUrl;
}
