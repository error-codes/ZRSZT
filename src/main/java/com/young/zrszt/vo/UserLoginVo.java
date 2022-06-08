package com.young.zrszt.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/30 15:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户登录视图对象")
public class UserLoginVo {

    @ApiModelProperty(value = "手机号", required = true)
    private String username;

    @ApiModelProperty(value = "验证码", required = true)
    private String verifyCode;
}
