package com.young.zrszt.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/16 13:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户视图对象")
public class UserVo {

    @ApiModelProperty("用户ID")
    @NotNull(message = "用户ID不能为空")
    private Long userId;

    @ApiModelProperty("昵称")
    @NotBlank(message = "昵称不能为空", groups = NickName.class)
    private String nickName;

    @ApiModelProperty("手机号")
    @NotBlank(message = "手机号格式错误", groups = Phone.class)
    private String phone;

    public interface NickName {
    }

    ;

    public interface Phone {
    }

    ;
}
