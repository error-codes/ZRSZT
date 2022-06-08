package com.young.zrszt.controller;

import com.young.zrszt.common.CommonDataResult;
import com.young.zrszt.common.CommonPage;
import com.young.zrszt.common.ResultMessage;
import com.young.zrszt.service.SearchService;
import com.young.zrszt.util.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/29 19:04
 */
@RestController
@RequestMapping("/search")
@Api(tags = "全局搜索")
public class SearchController {

    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @ApiOperation("要闻关键字搜索")
    @GetMapping("/news")
    public CommonDataResult<CommonPage<?>> search(@RequestParam @NotNull @ApiParam("用户ID") Long userId,
                                                  @RequestParam @NotBlank @ApiParam("搜索关键字") String keyword) {
        CommonPage<?> search = searchService.search(userId, keyword);
        return ResultUtils.success(ResultMessage.QUERY_SUCCESS, search);
    }
}
