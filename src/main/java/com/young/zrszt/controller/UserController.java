package com.young.zrszt.controller;

import com.young.zrszt.common.CommonDataResult;
import com.young.zrszt.common.CommonResult;
import com.young.zrszt.common.ResultMessage;
import com.young.zrszt.entity.User;
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

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/12 23:09
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("根据主键查询用户信息")
    @GetMapping("/selectByPrimary")
    public CommonDataResult<User> selectByPrimary(@RequestParam Long userId) {
        return ResultUtils.success(userService.selectUserByPrimaryKey(userId));
    }

    @ApiOperation("注册用户")
    @PostMapping("/register")
    public CommonResult register(@RequestBody RegisterVo registerVo) {
        Integer result = userService.createUser(registerVo);
        System.out.println(result);
        if (result != 1) {
            return ResultUtils.failed(ResultMessage.REGISTER_FAILED);
        } else {
            return ResultUtils.success(ResultMessage.REGISTER_SUCCESS);
        }
    }

    @ApiOperation("修改用户头像")
    @PostMapping("/update/avatar")
    public CommonResult avatar(@RequestParam("file") MultipartFile file,
                               @RequestParam("userId") Long userId) {
        String imageName = file.getOriginalFilename();

        Integer result = userService.createUser(registerVo);
        System.out.println(result);
        if (result != 1) {
            return ResultUtils.failed(ResultMessage.REGISTER_FAILED);
        } else {
            return ResultUtils.success(ResultMessage.REGISTER_SUCCESS);
        }
    }

    @ApiOperation("修改用户手机号")
    @PostMapping("/update/phone")
    public CommonResult register(@Validated(UserVo.Phone.class) @RequestBody UserVo userVo) {
        Integer result = userService.createUser(registerVo);
        System.out.println(result);
        if (result != 1) {
            return ResultUtils.failed(ResultMessage.REGISTER_FAILED);
        } else {
            return ResultUtils.success(ResultMessage.REGISTER_SUCCESS);
        }
    }

    @ApiOperation("修改用户昵称")
    @PostMapping("/update/nickName")
    public CommonResult nickName(@Validated(UserVo.NickName.class) @RequestBody UserVo userVo) {
        Integer result = userService.createUser(registerVo);
        System.out.println(result);
        if (result != 1) {
            return ResultUtils.failed(ResultMessage.REGISTER_FAILED);
        } else {
            return ResultUtils.success(ResultMessage.REGISTER_SUCCESS);
        }
    }
}
