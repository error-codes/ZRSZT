package com.young.zrszt.vo;

import com.young.zrszt.entity.User;
import com.young.zrszt.enums.Channel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/31 17:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("频道视图对象")
public class ChannelVo {

    @ApiModelProperty(value = "用户ID", required = true)
    @NotNull(message = "用户ID不能为空")
    private Long userId;

    @ApiModelProperty(value = "频道ID列表   可用值:     HANGYEZHUGUAN, GUOZIYANGQI, " +
            "JITUANZONGBU, CHANPINXIAN, TONGHANGDONGTAI, GUOJIABUWEI, ZHILIANGYAOWEN, " +
            "BIAOZHUNHUA, EHS, NENGYUANGUANLI, SHUZIHUA, ZHILIANGGUANLI, RENZHENGQUAN, " +
            "XIANJINZHIZAO, LVSEDITAN, ESG, GONGYINGLIANGUANLI, HEGUIFENGKONG, ZHONGXIAOWEIQIYE, " +
            "GUANLIDONGCHA, ZHILIANGJIANG, NUM16949, SHIPINZHILIANGANQUAN", required = true)
    @NotEmpty(message = "频道ID列表不能为空")
    private List<Channel> channels;

}
