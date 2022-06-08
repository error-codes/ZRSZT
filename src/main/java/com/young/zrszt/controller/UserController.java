package com.young.zrszt.controller;

import com.young.zrszt.common.CommonDataResult;
import com.young.zrszt.common.CommonResult;
import com.young.zrszt.common.ResultMessage;
import com.young.zrszt.dto.UserDetailsDto;
import com.young.zrszt.entity.YcrUserDetails;
import com.young.zrszt.enums.UploadPath;
import com.young.zrszt.entity.User;
import com.young.zrszt.service.FileService;
import com.young.zrszt.service.UserService;
import com.young.zrszt.util.RedisUtils;
import com.young.zrszt.util.ResultUtils;
import com.young.zrszt.util.YcrUtils;
import com.young.zrszt.vo.RegisterVo;
import com.young.zrszt.vo.UserLoginVo;
import com.young.zrszt.vo.UserVo;
import com.young.zrszt.vo.VerifyCodeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

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
    private final PasswordEncoder passwordEncoder;
    private final RedisUtils redisUtils;

    @Autowired
    public UserController(UserService userService, FileService fileService, PasswordEncoder passwordEncoder, RedisUtils redisUtils) {
        this.userService = userService;
        this.fileService = fileService;
        this.passwordEncoder = passwordEncoder;
        this.redisUtils = redisUtils;
    }

    @ApiOperation("根据主键查询用户信息")
    @GetMapping("/selectUserById")
    public CommonDataResult<User> selectUserById(@RequestParam @NotNull Long userId) {
        return ResultUtils.success(userService.selectUserById(userId));
    }

    @ApiOperation("新增用户")
    @PostMapping("/register")
    public CommonResult register(@RequestBody @NotNull RegisterVo registerVo) {
        Integer result = userService.createUser(registerVo);
        if (result == -1) {
            return ResultUtils.failed(ResultMessage.USER_EXIST);
        } else if (result != 1) {
            return ResultUtils.failed(ResultMessage.REGISTER_FAILED);
        } else {
            return ResultUtils.success(ResultMessage.REGISTER_SUCCESS);
        }
    }

    @ApiOperation("修改用户头像")
    @PostMapping("/update/avatar")
    public CommonResult avatar(@RequestPart("file") @NotNull MultipartFile file,
                               @RequestParam("userId") @NotNull Long userId) throws IOException {
        String url = fileService.uploadFile(file, UploadPath.AVATAR);
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

    @ApiOperation("发送验证码")
    @PostMapping("/sendVerifyCode")
    public CommonDataResult<String> sendVerifyCode(@RequestBody @NotNull VerifyCodeVo verifyCodeVo) {
        String verifyCode = YcrUtils.generateVerifyCode();
        boolean set = redisUtils.set(verifyCodeVo.getPhone(), passwordEncoder.encode(verifyCode), TimeUnit.MINUTES.toSeconds(5));
        if (!set) {
            return ResultUtils.failed("验证码生成失败", null);
        }
        return ResultUtils.success("验证码生成成功", verifyCode);
    }

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public CommonDataResult<UserDetailsDto> login(@RequestBody @NotNull UserLoginVo userLoginVo) {
        String verifyCode = (String) redisUtils.get(userLoginVo.getUsername());
        return userService.login(verifyCode, userLoginVo);
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/getUserInfo")
    public CommonDataResult<YcrUserDetails> getUserInfo(@RequestParam @NotBlank @ApiParam("用户Token令牌") String token) {
        return ResultUtils.success(ResultMessage.QUERY_SUCCESS, userService.getUserInfo(token));
    }


}
