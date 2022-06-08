package com.young.zrszt.service;

import com.young.zrszt.common.CommonDataResult;
import com.young.zrszt.dto.UserDetailsDto;
import com.young.zrszt.entity.User;
import com.young.zrszt.entity.YcrUserDetails;
import com.young.zrszt.vo.RegisterVo;
import com.young.zrszt.vo.UserLoginVo;
import com.young.zrszt.vo.UserVo;

import javax.servlet.http.HttpSession;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/12 23:06
 */
public interface UserService {

    /**
     * 根据主键查询用户信息
     *
     * @param userId 用户ID
     * @return User信息
     */
    User selectUserById(Long userId);

    /**
     * 创建一个用户
     *
     * @param registerVo 注册信息
     * @return 注册结果
     */
    Integer createUser(RegisterVo registerVo);

    /**
     * 修改用户头像
     *
     * @param avatar 头像
     * @param userId 用户ID
     * @return 修改结果
     */
    Integer updateAvatar(String avatar, Long userId);

    /**
     * 修改用户手机号
     *
     * @param userVo 用户信息
     * @return 修改结果
     */
    Integer updatePhone(UserVo userVo);

    /**
     * 修改用户昵称
     *
     * @param userVo 用户信息
     * @return 修改结果
     */
    Integer updateNickName(UserVo userVo);

    /**
     * 用户登录
     *
     * @param verifyCode 验证码
     * @param userLoginVo 用户登录视图对象
     * @return 用户信息
     */
    CommonDataResult<UserDetailsDto> login(String verifyCode, UserLoginVo userLoginVo);

    /**
     * 根据Token获取用户信息
     *
     * @param token token
     * @return 用户信息
     */
    YcrUserDetails getUserInfo(String token);
}
