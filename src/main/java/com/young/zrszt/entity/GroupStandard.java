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
 * @since 2022/5/31 15:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("团体标准")
public class GroupStandard {

    @ApiModelProperty("标准ID")
    private Long id;

    @ApiModelProperty("详情链接")
    private Long url;

    @ApiModelProperty("中文标准名称")
    private String nameCn;

    @ApiModelProperty("国际标准名称")
    private String nameEn;

    @ApiModelProperty("团体名称")
    private String teamName;

    @ApiModelProperty("标准状态")
    private String status;

    @ApiModelProperty("公布日期")
    private Date pubDate;

    @ApiModelProperty("可出售标准")
    private boolean isSale;

    @ApiModelProperty("团体承诺")
    private String groupComm;

    @ApiModelProperty("登记证号")
    private String regNo;

    @ApiModelProperty("团体编号")
    private String teamCode;

    @ApiModelProperty("发证机关")
    private String issueAuth;

    @ApiModelProperty("业务范围")
    private String businessScope;

    @ApiModelProperty("法定代表人")
    private String legal;

    @ApiModelProperty("依托单位名称")
    private String supportUnit;

    @ApiModelProperty("通信地址")
    private String addr;

    @ApiModelProperty("邮编")
    private String postCode;

    @ApiModelProperty("是否公开")
    private boolean isPub;

    @ApiModelProperty("国民经济分类")
    private String category;

    @ApiModelProperty("发布时间")
    private Date issueDate;

    @ApiModelProperty("实施时间")
    private Date actDate;

    @ApiModelProperty("中国标准分类号")
    private String ccs;

    @ApiModelProperty("国际标准分类号")
    private String ics;

    @ApiModelProperty("起草单位")
    private List<String> draftUnit;

    @ApiModelProperty("起草人")
    private List<String> draftStaff;

    @ApiModelProperty("标准正文")
    private String pdfUrl1;

    @ApiModelProperty("范围")
    private String scope;

    @ApiModelProperty("主要技术内容")
    private String techInfo;

    @ApiModelProperty("是否包含专利信息")
    private String patentInfo;

    @ApiModelProperty("标准公告")
    private String pdfUrl2;

    @ApiModelProperty("标准公告时间")
    private Date annTime;

    @ApiModelProperty("购买信息-链接")
    private String buyUrl;

    @ApiModelProperty("购买信息-价格")
    private String price;

    @ApiModelProperty("购买信息-联系人")
    private String contact;

    @ApiModelProperty("购买信息-联系电话")
    private String phone1;

    @ApiModelProperty("购买信息-手机号码")
    private String phone2;

    @ApiModelProperty("购买信息-传真")
    private String fax;

    @ApiModelProperty("购买信息-邮箱")
    private String email;

    @ApiModelProperty("购买信息-简介")
    private String buyDesc;

    @ApiModelProperty("采集时间")
    private Date gatherTime;
}
