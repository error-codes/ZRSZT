package com.young.zrszt.enums;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/31 12:52
 */
@Getter
@AllArgsConstructor
@ApiModel("频道")
public enum Channel {

    @ApiModelProperty("要闻")
    YAOWEN(0),
    @ApiModelProperty("行业主管")
    HANGYEZHUGUAN(1),
    @ApiModelProperty("国资央企")
    GUOZIYANGQI(2),
    @ApiModelProperty("集团总部")
    JITUANZONGBU(3),
    @ApiModelProperty("产品线")
    CHANPINXIAN(4),
    @ApiModelProperty("同行动态")
    TONGHANGDONGTAI(5),
    @ApiModelProperty("国家部委")
    GUOJIABUWEI(6),

    @ApiModelProperty("质量要闻")
    ZHILIANGYAOWEN(7),
    @ApiModelProperty("标准化")
    BIAOZHUNHUA(8),
    @ApiModelProperty("EHS")
    EHS(9),
    @ApiModelProperty("能源管理")
    NENGYUANGUANLI(10),
    @ApiModelProperty("数字化")
    SHUZIHUA(11),
    @ApiModelProperty("质量管理")
    ZHILIANGGUANLI(12),
    @ApiModelProperty("认证圈")
    RENZHENGQUAN(13),
    @ApiModelProperty("先进制造")
    XIANJINZHIZAO(14),
    @ApiModelProperty("绿色低碳")
    LVSEDITAN(15),
    @ApiModelProperty("ESG")
    ESG(16),
    @ApiModelProperty("供应链管理")
    GONGYINGLIANGUANLI(17),
    @ApiModelProperty("合规风控")
    HEGUIFENGKONG(18),
    @ApiModelProperty("中小微企业")
    ZHONGXIAOWEIQIYE(19),
    @ApiModelProperty("管理洞察")
    GUANLIDONGCHA(20),
    @ApiModelProperty("质量奖")
    ZHILIANGJIANG(21),
    @ApiModelProperty("16949")
    NUM16949(22),
    @ApiModelProperty("食品质量安全")
    SHIPINZHILIANGANQUAN(23);

    private final Integer channel;

    public static Channel getChannel(Integer channel) {
        for (Channel value : Channel.values()) {
            if(value.channel.equals(channel)) {
                return value;
            }
        }
        return null;
    }
}
