package com.young.zrszt.service.impl;

import com.young.zrszt.entity.User;
import com.young.zrszt.mapper.UserMapper;
import com.young.zrszt.service.UserService;
import com.young.zrszt.util.SnowFlakeUtils;
import com.young.zrszt.vo.RegisterVo;
import com.young.zrszt.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/12 23:07
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User selectUserById(Long userId) {
        return userMapper.selectUserById(userId);
    }

    @Override
    public Integer createUser(RegisterVo registerVo) {
        User user = new User();
        BeanUtils.copyProperties(registerVo, user);
        user.setUserId(SnowFlakeUtils.getSnowFlakeId());
        return userMapper.createUser(user);
    }

    @Override
    public Integer updateAvatar(String avatar, Long userId) {
        return userMapper.updateAvatar(avatar, userId);
    }

    @Override
    public Integer updatePhone(UserVo userVo) {
        return userMapper.updatePhone(userVo.getPhone(), userVo.getUserId());
    }

    @Override
    public Integer updateNickName(UserVo userVo) {
        return userMapper.updateNickName(userVo.getNickName(), userVo.getUserId());
    }
}
