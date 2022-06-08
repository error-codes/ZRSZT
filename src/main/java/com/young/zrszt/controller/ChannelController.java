package com.young.zrszt.controller;

import com.young.zrszt.common.CommonDataResult;
import com.young.zrszt.common.CommonResult;
import com.young.zrszt.common.ResultMessage;
import com.young.zrszt.enums.Channel;
import com.young.zrszt.service.ChannelService;
import com.young.zrszt.util.ResultUtils;
import com.young.zrszt.vo.ChannelVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/31 17:12
 */
@RestController
@RequestMapping("/channel")
@Api(tags = "频道接口")
public class ChannelController {

    private final ChannelService channelService;

    @Autowired
    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @ApiOperation("删除频道")
    @PostMapping("/delete")
    public CommonResult delete(@RequestBody @NotNull ChannelVo channelVo) {
        Integer deleteChannel = channelService.batchDeleteChannel(channelVo);
        if (deleteChannel != 1) {
            return ResultUtils.failed(ResultMessage.DELETE_FAILED);
        } else {
            return ResultUtils.success(ResultMessage.DELETE_SUCCESS);
        }
    }

    @ApiOperation("增加频道")
    @PostMapping("/add")
    public CommonResult add(@RequestBody @NotNull ChannelVo channelVo) {
        Integer addChannel = channelService.addChannel(channelVo);
        if (addChannel != 1) {
            return ResultUtils.failed(ResultMessage.ADD_FAILED);
        } else {
            return ResultUtils.success(ResultMessage.ADD_SUCCESS);
        }
    }

    @ApiOperation("查询用户频道")
    @GetMapping("/getUserChannel")
    public CommonDataResult<List<Channel>> add(@RequestParam @NotNull @ApiParam("用户ID") Long userId) {
        return ResultUtils.success(ResultMessage.QUERY_SUCCESS, channelService.selectChannelByUser(userId));
    }
}
