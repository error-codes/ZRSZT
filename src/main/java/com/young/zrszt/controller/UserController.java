package com.young.zrszt.controller;

import com.young.zrszt.common.CommonDataResult;
import com.young.zrszt.common.CommonResult;
import com.young.zrszt.common.ResultMessage;
import com.young.zrszt.enums.UploadPathEnum;
import com.young.zrszt.entity.User;
import com.young.zrszt.service.FileService;
import com.young.zrszt.service.UserService;
import com.young.zrszt.util.ResultUtils;
import com.young.zrszt.vo.RegisterVo;
import com.young.zrszt.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.IOException;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/12 23:09
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户接口")
public class UserController {

    private final UserService userService;
    private final FileService fileService;

    @Autowired
    public UserController(UserService userService, FileService fileService) {
        this.userService = userService;
        this.fileService = fileService;
    }

    @ApiOperation("根据主键查询用户信息")
    @GetMapping("/selectUserById")
    public CommonDataResult<User> selectUserById(@RequestParam @NotNull Long userId) {
        return ResultUtils.success(userService.selectUserById(userId));
    }

    @ApiOperation("注册用户")
    @PostMapping("/register")
    public CommonResult register(@RequestBody @NotNull RegisterVo registerVo) {
        Integer result = userService.createUser(registerVo);
        if (result != 1) {
            return ResultUtils.failed(ResultMessage.REGISTER_FAILED);
        } else {
            return ResultUtils.success(ResultMessage.REGISTER_SUCCESS);
        }
    }

    @ApiOperation("修改用户头像")
    @PostMapping("/update/avatar")
    public CommonResult avatar(@RequestPart("file") @NotNull MultipartFile file,
                               @RequestParam("userId") @NotNull Long userId) throws IOException {
        String url = fileService.uploadFile(file, UploadPathEnum.AVATAR);
        Integer result = userService.updateAvatar(url, userId);
        if (result != 1) {
            return ResultUtils.failed(ResultMessage.UPDATE_FAILED);
        } else {
            return ResultUtils.success(ResultMessage.UPDATE_SUCCESS);
        }
    }

    @ApiOperation("修改用户手机号")
    @PostMapping("/update/phone")
    public CommonResult phone(@Validated(UserVo.Phone.class) @RequestBody @NotNull UserVo userVo) {
        Integer result = userService.updatePhone(userVo);
        if (result != 1) {
            return ResultUtils.failed(ResultMessage.UPDATE_FAILED);
        } else {
            return ResultUtils.success(ResultMessage.UPDATE_SUCCESS);
        }
    }

    @ApiOperation("修改用户昵称")
    @PostMapping("/update/nickName")
    public CommonResult nickName(@Validated(UserVo.NickName.class) @RequestBody @NotNull UserVo userVo) {
        Integer result = userService.updateNickName(userVo);
        if (result != 1) {
            return ResultUtils.failed(ResultMessage.UPDATE_FAILED);
        } else {
            return ResultUtils.success(ResultMessage.UPDATE_SUCCESS);
        }
    }
}
