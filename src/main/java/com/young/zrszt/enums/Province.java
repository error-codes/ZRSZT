package com.young.zrszt.enums;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/26 15:36
 */
@Getter
@AllArgsConstructor
@ApiModel("省")
public enum Province {

    BEIJING("北京", 1),
    TIANJIN("天津", 2),
    HEBEI("河北", 3),
    SHANXI("山西", 4),
    NEIMENGGU("内蒙古", 5),
    LIAONING("辽宁", 6),
    JILIN("吉林", 7),
    HEILONGJIANG("黑龙江", 8),
    SHANGHAI("上海", 9),
    JIANGSU("江苏", 10),
    ZHEJIANG("浙江", 11),
    ANHUI("安徽", 12),
    FUJIAN("福建", 13),
    JIANGXI("江西", 14),
    SHANDONG("山东", 15),
    HENAN("河南", 16),
    HUBEI("湖北", 17),
    HUNAN("湖南", 18),
    GUANGDONG("广东", 19),
    GUANGXI("广西", 20),
    HAINAN("海南", 21),
    CHONGQING("重庆", 22),
    SICHUAN("四川", 23),
    GUIZHOU("贵州", 24),
    YUNNAN("云南", 25),
    XIZANG("西藏", 26),
    SHAANXI("陕西", 27),
    GANSU("甘肃", 28),
    QINGHAI("青海", 29),
    NINGXIA("宁夏", 30),
    XINJIANG("新疆", 31);

    private final String province;
    private final Integer code;
}
