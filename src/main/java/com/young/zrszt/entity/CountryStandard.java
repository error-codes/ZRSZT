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
 * @since 2022/5/24 18:49
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("国家标准")
public class CountryStandard {

    @ApiModelProperty("标准ID")
    private Long id;

    @ApiModelProperty("国家标准号")
    private String code;

    @ApiModelProperty("详情链接")
    private String url;

    @ApiModelProperty("标准性质")
    private String nature;

    @ApiModelProperty("标准类型")
    private String stdType;
    
    @ApiModelProperty("标准状态")
    private String state;

    @ApiModelProperty("被代替国标号")
    private String repedBy;

    @ApiModelProperty("主管部门")
    private String department;
    
    @ApiModelProperty("归口单位")
    private String ownerUnit;

    @ApiModelProperty("执行单位")
    private String executeUnit;
    
    @ApiModelProperty("中文标准名称")
    private String nameCn;

    @ApiModelProperty("英文标准名称")
    private String nameEn;

    @ApiModelProperty("发布时间")
    private Date startDate;

    @ApiModelProperty("实施时间")
    private Date actDate;

    @ApiModelProperty("废止时间")
    private Date endDate;

    @ApiModelProperty("中国标准分类号")
    private String ccs;

    @ApiModelProperty("国际标准分类号")
    private String ics;

    @ApiModelProperty("起草单位")
    private List<String> draftUnit;

    @ApiModelProperty("起草人")
    private List<String> draftStaff;

    @ApiModelProperty("采标号")
    private String adoptNo;

    @ApiModelProperty("采用国际标准类别")
    private String adoptType;

    @ApiModelProperty("采用程度")
    private String adoptLevel;

    @ApiModelProperty("相近标准【计划】")
    private List<String> similarPlan;

    @ApiModelProperty("标准标签")
    private List<String> label;

    @ApiModelProperty("标准介绍")
    private String description;

    @ApiModelProperty("标准正文")
    private String pdfUrl;

    @ApiModelProperty("采集时间")
    private Date gatherTime;

}
