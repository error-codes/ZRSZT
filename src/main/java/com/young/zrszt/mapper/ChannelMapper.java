package com.young.zrszt.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/31 17:27
 */
@Mapper
public interface ChannelMapper {

    /**
     * 批量删除频道
     *
     * @param userId   用户ID
     * @param channels 频道ID列表
     * @return 删除结果
     */
    Integer batchDeleteChannel(Long userId, String channels);

    /**
     * 增加频道
     *
     * @param userId   用户ID
     * @param channels 频道ID
     * @return 增加结果
     */
    Integer addChannel(Long userId, String channels);

    /**
     * 查询频道
     *
     * @param userId 用户ID
     * @return 频道列表
     */
    String selectChannelByUser(Long userId);
}
