package com.young.zrszt.service;

import com.young.zrszt.entity.User;
import com.young.zrszt.vo.RegisterVo;
import com.young.zrszt.vo.UserVo;
import org.springframework.stereotype.Service;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/12 23:06
 */
public interface UserService {

    /**
     * 根据主键查询用户信息
     * @param userId
     * @return
     */
    User selectUserByPrimaryKey(Long userId);

    /**
     * 创建一个用户
     * @param registerVo
     * @return
     */
    Integer createUser(RegisterVo registerVo);

    /**
     * 修改用户头像
     *
     * @param avatar
     * @param userId
     * @return
     */
    Integer updateAvatar(String avatar, Long userId);

    /**
     * 修改用户手机号
     *
     * @param userVo
     * @return
     */
    Integer updatePhone(UserVo userVo);

    /**
     * 修改用户昵称
     *
     * @param userVo
     * @return
     */
    Integer updateNickName(UserVo userVo);
}
