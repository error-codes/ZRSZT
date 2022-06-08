package com.young.zrszt.service;

import com.young.zrszt.enums.Channel;
import com.young.zrszt.vo.ChannelVo;

import java.util.List;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/31 17:12
 */
public interface ChannelService {

    /**
     * 批量删除频道
     *
     * @param channelVo 频道视图对象
     * @return 删除结果
     */
    Integer batchDeleteChannel(ChannelVo channelVo);

    /**
     * 增加频道
     *
     * @param channelVo 频道视图对象
     * @return 增加结果
     */
    Integer addChannel(ChannelVo channelVo);

    /**
     * 根据用户ID查找用户频道
     *
     * @param userId 用户ID
     * @return 用户频道
     */
    List<Channel> selectChannelByUser(Long userId);
}
