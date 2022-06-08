package com.young.zrszt.controller;

import com.young.zrszt.common.CommonDataResult;
import com.young.zrszt.common.CommonPage;
import com.young.zrszt.common.CommonResult;
import com.young.zrszt.common.ResultMessage;
import com.young.zrszt.entity.SearchHistory;
import com.young.zrszt.service.SearchHistoryService;
import com.young.zrszt.service.SearchService;
import com.young.zrszt.util.ResultUtils;
import com.young.zrszt.vo.CommonIdVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author error-codes【BayMax】
 * @description
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/6/4 18:36
 */
@RestController
@RequestMapping("/searchHistory")
@Api(tags = "搜索历史")
public class SearchHistoryController {

    private final SearchHistoryService searchHistoryService;

    @Autowired
    public SearchHistoryController(SearchHistoryService searchHistoryService) {
        this.searchHistoryService = searchHistoryService;
    }

    @ApiOperation("展示搜索历史列表")
    @GetMapping("/list")
    public CommonDataResult<CommonPage<SearchHistory>> listBrowseHistory(@RequestParam(defaultValue = "1") @ApiParam("页码") Integer page,
                                                                         @RequestParam(defaultValue = "20") @ApiParam("单页装载数量") Integer size,
                                                                         @RequestParam @NotNull @ApiParam("用户ID") Long userId) {
        CommonPage<SearchHistory> searchHistory = searchHistoryService.listBrowseHistory(page, size, userId);
        return ResultUtils.success(ResultMessage.QUERY_SUCCESS, searchHistory);
    }

    @ApiOperation("删除搜索记录")
    @PostMapping("/delete")
    public CommonResult deleteBrowseHistory(@RequestBody @NotNull @ApiParam("搜索历史") CommonIdVo commonIdVo) {
        Integer result = searchHistoryService.deleteBrowseHistory(commonIdVo);
        if (result != 1) {
            return ResultUtils.failed(ResultMessage.DELETE_FAILED);
        }
        return ResultUtils.success(ResultMessage.QUERY_SUCCESS);
    }
}
