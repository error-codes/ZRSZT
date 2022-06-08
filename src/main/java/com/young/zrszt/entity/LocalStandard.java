package com.young.zrszt.entity;

import com.young.zrszt.enums.Province;
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
 * @since 2022/5/25 19:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("地方标准")
public class LocalStandard {

    @ApiModelProperty("标准ID")
    private Long id;

    @ApiModelProperty("详情链接")
    private Long url;

    @ApiModelProperty("地方标准号")
    private String code; 

    @ApiModelProperty("所属地方")
    private Province province;

    @ApiModelProperty("技术归口")
    private String tecBelong;

    @ApiModelProperty("批准发布部门")
    private String chargeDept;

    @ApiModelProperty("中文标准名称")
    private String cnName;

    @ApiModelProperty("发布时间")
    private Date releaseTime;

    @ApiModelProperty("实施时间")
    private Date implementTime;

    @ApiModelProperty("废止时间")
    private Date repealTime;

    @ApiModelProperty("中国标准分类号")
    private String cnCategoryCode;

    @ApiModelProperty("国际标准分类号")
    private String enCategoryCode;

    @ApiModelProperty("起草单位")
    private List<String> draftUnit;

    @ApiModelProperty("起草人")
    private List<String> drafter;

    @ApiModelProperty("标准标签")
    private List<String> label;

    @ApiModelProperty("备案时间")
    private Date recordTime;

    @ApiModelProperty("备案号")
    private String recordCode;

    @ApiModelProperty("备案信息")
    private String recordInfo;

    @ApiModelProperty("制修订")
    private String revision;

    @ApiModelProperty("代替标准")
    private String replace;

    @ApiModelProperty("标准类型")
    private String stdType;

    @ApiModelProperty("行业分类")
    private String category;

    @ApiModelProperty("适用范围")
    private String scope;

    @ApiModelProperty("标准正文")
    private String pdfUrl;

    @ApiModelProperty("采集时间")
    private Date gatherTime;
}
