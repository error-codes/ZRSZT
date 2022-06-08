package com.young.zrszt.enums;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/17 15:34
 */
@Getter
@AllArgsConstructor
@ApiModel("上传路径")
public enum UploadPath {

    @ApiModelProperty("头像路径")
    AVATAR("/avatar/");

    private final String path;
}
