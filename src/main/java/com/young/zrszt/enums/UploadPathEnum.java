package com.young.zrszt.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/17 15:34
 */
@Getter
@AllArgsConstructor
public enum UploadPathEnum {

    /**
     * 头像路径
     */
    AVATAR("/avatar/");

    private final String path;
}
