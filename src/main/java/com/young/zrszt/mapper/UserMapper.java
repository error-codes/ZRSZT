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
     * @param userId
     * @return
     */
    User selectUserByPrimaryKey(@Param("userId") Long userId);

    /**
     * 创建一个用户
     *
     * @param user
     * @return
     */
    Integer createUser(User user);

    /**
     * 修改用户头像
     *
     * @param avatar
     * @param userId
     * @return
     */
    Integer updateAvatar(@Param("avatar") String avatar, @Param("userId") Long userId);

    /**
     * 修改用户手机号
     *
     * @param phone
     * @param userId
     * @return
     */
    Integer updatePhone(@Param("phone") String phone, @Param("userId") Long userId);

    /**
     * 修改用户昵称
     *
     * @param nickName
     * @param userId
     * @return
     */
    Integer updateNickName(@Param("nickName") String nickName, @Param("userId") Long userId);
}
