package com.young.zrszt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/13 0:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterVo {

    @NotBlank
    private String nickName;

    @NotBlank
    private String avatar;

    @NotBlank
    private String phone;
}
