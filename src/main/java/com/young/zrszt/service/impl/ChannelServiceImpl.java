package com.young.zrszt.service.impl;

import com.young.zrszt.enums.Channel;
import com.young.zrszt.mapper.ChannelMapper;
import com.young.zrszt.service.ChannelService;
import com.young.zrszt.vo.ChannelVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/31 17:12
 */
@Service("channelService")
public class ChannelServiceImpl implements ChannelService {

    @Resource
    private ChannelMapper channelMapper;

    @Override
    public Integer batchDeleteChannel(ChannelVo channelVo) {
        List<Channel> deleteChannels = channelVo.getChannels();
        String channelByUser = channelMapper.selectChannelByUser(channelVo.getUserId());
        List<String> channels = Arrays.asList(channelByUser.split("&"));
        List<String> channelList = channels.stream()
                .filter(channel -> !deleteChannels.contains(Channel.getChannel(Integer.valueOf(channel)))).collect(Collectors.toList());
        if (channelList.size() != channels.size()) {
            StringBuilder channelBuilder = new StringBuilder();
            channelList.stream().forEach(channel -> channelBuilder.append(channel + "&"));
            return channelMapper.batchDeleteChannel(channelVo.getUserId(), channelBuilder.toString());
        }
        return 0;
    }

    @Override
    public Integer addChannel(ChannelVo channelVo) {
        List<Channel> addChannels = channelVo.getChannels();
        String channelByUser = channelMapper.selectChannelByUser(channelVo.getUserId());
        List<String> channels = Arrays.asList(channelByUser.split("&"));
        List<Channel> channelList = addChannels.stream()
                .filter(channel -> !channels.contains(String.valueOf(channel.getChannel()))).collect(Collectors.toList());
        if (channelList != null && !channelList.isEmpty()) {
            StringBuilder channelBuilder = new StringBuilder(channelByUser);
            channelList.stream().forEach(channel -> channelBuilder.append(channel.getChannel() + "&"));
            return channelMapper.addChannel(channelVo.getUserId(), channelBuilder.toString());
        }
        return 0;
    }

    @Override
    public List<Channel> selectChannelByUser(Long userId) {
        String channelByUser = channelMapper.selectChannelByUser(userId);
        return Arrays.asList(channelByUser.split("&")).stream().map(channel -> Channel.getChannel(Integer.valueOf(channel))).collect(Collectors.toList());
    }
}
