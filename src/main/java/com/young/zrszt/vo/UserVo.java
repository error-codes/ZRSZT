package com.young.zrszt.vo;

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
public class UserVo {

    @NotNull
    private Long userId;

    @NotBlank(groups = NickName.class)
    private String nickName;

    @NotBlank(groups = Phone.class)
    private String phone;

    public interface NickName{};

    public interface Phone{};
}
