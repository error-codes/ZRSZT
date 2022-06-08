package com.young.zrszt.service.impl;

import com.young.zrszt.annotation.PhoneValidation;
import com.young.zrszt.common.CommonDataResult;
import com.young.zrszt.common.ResultMessage;
import com.young.zrszt.dto.UserDetailsDto;
import com.young.zrszt.entity.User;
import com.young.zrszt.entity.YcrUserDetails;
import com.young.zrszt.enums.Channel;
import com.young.zrszt.mapper.UserMapper;
import com.young.zrszt.service.UserService;
import com.young.zrszt.util.JwtUtils;
import com.young.zrszt.util.RedisUtils;
import com.young.zrszt.util.ResultUtils;
import com.young.zrszt.util.SnowFlakeUtils;
import com.young.zrszt.vo.RegisterVo;
import com.young.zrszt.vo.UserLoginVo;
import com.young.zrszt.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/12 23:07
 */
@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User selectUserById(Long userId) {
        return userMapper.selectUserById(userId);
    }

    @Override
    public Integer createUser(RegisterVo registerVo) {
        User exist = userMapper.selectUserByPhone(registerVo.getPhone());
        if(exist == null) {
            User user = new User();
            BeanUtils.copyProperties(registerVo, user);
            user.setUserId(SnowFlakeUtils.getSnowFlakeId());
            user.setChannel("0&1&2&3&4&5&6&");
            return userMapper.createUser(user);
        }
        return -1;
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

    @Override
    public YcrUserDetails loadUserByUsername(String userName) {
        User user = userMapper.selectUserByPhone(userName);
        if (Objects.isNull(user)) {
            return null;
        }
        List<Channel> channels = Arrays.asList(user.getChannel().split("&")).stream()
                .map(channel -> Channel.getChannel(Integer.valueOf(channel))).collect(Collectors.toList());
        return new YcrUserDetails(user.getUserId(), user.getNickName(), user.getAvatar(), user.getPhone(), channels);
    }

    @Override
    public CommonDataResult<UserDetailsDto> login(String verifyCode, UserLoginVo userLoginVo) {
        if (StringUtils.isBlank(userLoginVo.getUsername()) || StringUtils.isBlank(userLoginVo.getVerifyCode())) {
            return ResultUtils.error(ResultMessage.PHONE_VERIFY_CODE_NOT_NULL, null);
        }
        if (!PhoneValidation.PATTERN.matcher(userLoginVo.getUsername()).matches()) {
            return ResultUtils.error(ResultMessage.PHONE_FORMAT_ERROR, null);
        }
        if (StringUtils.isBlank(verifyCode) || !passwordEncoder.matches(userLoginVo.getVerifyCode(), verifyCode)) {
            return ResultUtils.error(ResultMessage.VERIFY_CODE_INPUT_ERROR, null);
        }
        YcrUserDetails userDetails = loadUserByUsername(userLoginVo.getUsername());
        String token = JwtUtils.createToken(userDetails);
        return ResultUtils.success(ResultMessage.LOGIN_SUCCESS, new UserDetailsDto(userDetails, token));
    }

    @Override
    public YcrUserDetails getUserInfo(String token) {
        return JwtUtils.getUserFromToken(token);
    }
}
