package com.young.zrszt.mapper;

import com.young.zrszt.entity.User;
import com.young.zrszt.vo.RegisterVo;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/12 15:01
 */
@Mapper
public interface UserMapper {

    /**
     * 根据主键查询用户信息
     *
     * @param userId 用户ID
     * @return 用户信息
     */
    User selectUserById(@Param("userId") Long userId);

    /**
     * 创建一个用户
     *
     * @param user 用户信息
     * @return 创建结果
     */
    Integer createUser(User user);

    /**
     * 修改用户头像
     *
     * @param avatar 头像
     * @param userId 用户ID
     * @return 修改结果
     */
    Integer updateAvatar(@Param("avatar") String avatar, @Param("userId") Long userId);

    /**
     * 修改用户手机号
     *
     * @param phone 手机号
     * @param userId 用户ID
     * @return 修改结果
     */
    Integer updatePhone(@Param("phone") String phone, @Param("userId") Long userId);

    /**
     * 修改用户昵称
     *
     * @param nickName 昵称
     * @param userId 用户ID
     * @return 修改结果
     */
    Integer updateNickName(@Param("nickName") String nickName, @Param("userId") Long userId);

    /**
     * 根据用户手机号查找用户
     *
     * @param phone 手机号
     * @return 用户信息
     */
    User selectUserByPhone(@Param("phone") String phone);
}
