package com.young.zrszt.entity;

import com.young.zrszt.enums.Channel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/12 14:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户")
public class User {

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("手机")
    private String phone;

    @ApiModelProperty("我的频道")
    private String channel;
}
