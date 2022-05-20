package com.young.zrszt.service;

import com.young.zrszt.entity.User;
import com.young.zrszt.vo.RegisterVo;
import com.young.zrszt.vo.UserVo;

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
}
