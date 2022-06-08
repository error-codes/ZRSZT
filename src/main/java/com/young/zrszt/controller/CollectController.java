package com.young.zrszt.controller;

import com.young.zrszt.common.CommonDataResult;
import com.young.zrszt.common.CommonResult;
import com.young.zrszt.common.ResultMessage;
import com.young.zrszt.service.CollectService;
import com.young.zrszt.util.ResultUtils;
import com.young.zrszt.vo.CollectVo;
import com.young.zrszt.vo.CommonIdVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/19 18:20
 */
@RestController
@RequestMapping("/collect")
@Api(tags = "收藏接口")
public class CollectController {

    private final CollectService collectService;

    @Autowired
    public CollectController(CollectService collectService) {
        this.collectService = collectService;
    }

    @ApiOperation("收藏")
    @PostMapping("/collect")
    public CommonDataResult<CommonIdVo> collect(@RequestBody @NotNull CollectVo collectVo) {
        Long collect = collectService.collect(collectVo);
        if (collect == -1L) {
            return ResultUtils.failed(ResultMessage.COLLECT_EXIST, null);
        } else if (collect == null) {
            return ResultUtils.failed(ResultMessage.COLLECT_FAILED, null);
        } else {
            return ResultUtils.success(ResultMessage.COLLECT_SUCCESS, new CommonIdVo(collect));
        }
    }

    @ApiOperation("取消收藏")
    @PostMapping("/unCollect")
    public CommonResult unCollect(@RequestBody @NotNull CommonIdVo commonIdVo) {
        Integer unCollect = collectService.unCollect(commonIdVo);
        if (unCollect != 1) {
            return ResultUtils.failed(ResultMessage.UN_COLLECT_FAILED);
        } else {
            return ResultUtils.success(ResultMessage.UN_COLLECT_SUCCESS);
        }
    }
}
