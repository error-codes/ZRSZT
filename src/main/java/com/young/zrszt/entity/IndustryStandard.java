package com.young.zrszt.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/29 12:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("行业标准")
public class IndustryStandard {

    @ApiModelProperty("标准ID")
    private Long id;

    @ApiModelProperty("详情链接")
    private Long url;

    @ApiModelProperty("国家标准号")
    private String code;

    @ApiModelProperty("中文标准名称")
    private String nameCn;

    @ApiModelProperty("行业领域")
    private String industry;

    @ApiModelProperty("实施时间")
    private Date actDate;

    @ApiModelProperty("备案时间")
    private Date recordDate;

    @ApiModelProperty("备案号")
    private String recordNo;

    @ApiModelProperty("标准正文")
    private String pdfUrl;

    @ApiModelProperty("技术归口")
    private String ownerUnit;

    @ApiModelProperty("批准发布部门")
    private String chargeDept;

    @ApiModelProperty("中国标准分类号")
    private String ccs;

    @ApiModelProperty("国际标准分类号")
    private String ics;

    @ApiModelProperty("发布时间")
    private Date issueDate;

    @ApiModelProperty("标准类型")
    private String category;

    @ApiModelProperty("行业分类")
    private String tradeClassified;

    @ApiModelProperty("制修订")
    private String zxd;

    @ApiModelProperty("废止时间")
    private Date endDate;

    @ApiModelProperty("起草单位")
    private List<String> draftUnit;

    @ApiModelProperty("起草人")
    private List<String> draftStaff;

    @ApiModelProperty("适用范围")
    private String suitScope;

    @ApiModelProperty("备案信息")
    private String recordInfo;

    @ApiModelProperty("部委")
    private String ministry;

    @ApiModelProperty("标准标签")
    private List<String> label;

    @ApiModelProperty("采集时间")
    private Date gatherTime;
}
