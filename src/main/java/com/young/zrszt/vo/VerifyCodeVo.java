package com.young.zrszt.vo;

import com.young.zrszt.annotation.Phone;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/30 14:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("发送验证码参数")
public class VerifyCodeVo {

    @Phone
    @ApiModelProperty(value = "手机号", required = true)
    private String phone;
}
