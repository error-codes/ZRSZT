package com.young.zrszt.controller;

import com.young.zrszt.common.CommonDataResult;
import com.young.zrszt.common.CommonPage;
import com.young.zrszt.common.CommonResult;
import com.young.zrszt.common.ResultMessage;
import com.young.zrszt.entity.News;
import com.young.zrszt.service.NewsService;
import com.young.zrszt.util.ResultUtils;
import com.young.zrszt.vo.CommonIdVo;
import com.young.zrszt.vo.NewsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/19 14:20
 */
@RestController
@RequestMapping("/news")
@Api(tags = "新闻接口")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @ApiOperation("根据主键查询新闻信息")
    @PostMapping("/selectNewsById")
    public CommonDataResult<News> selectNewsById(@RequestBody @NotNull CommonIdVo commonIdVo) {
        return ResultUtils.success(newsService.selectNewsById(commonIdVo));
    }

    @ApiOperation("删除新闻信息")
    @PostMapping("/deleteNews")
    public CommonResult deleteNews(@RequestBody @NotNull CommonIdVo commonIdVo) {
        Integer delete = newsService.delete(commonIdVo);
        if (delete != 1) {
            return ResultUtils.failed(ResultMessage.DELETE_FAILED);
        } else {
            return ResultUtils.success(ResultMessage.DELETE_SUCCESS);
        }
    }

    @ApiOperation("创建新闻信息")
    @PostMapping("/createNews")
    public CommonResult createNews(@RequestBody @NotNull NewsVo newsVo) {
        Integer create = newsService.create(newsVo);
        if (create != 1) {
            return ResultUtils.failed(ResultMessage.ADD_FAILED);
        } else {
            return ResultUtils.success(ResultMessage.ADD_SUCCESS);
        }
    }

    @ApiOperation("修改新闻信息")
    @PostMapping("/updateNews")
    public CommonResult updateNews(@RequestBody @NotNull NewsVo newsVo) {
        Integer update = newsService.update(newsVo);
        if (update != 1) {
            return ResultUtils.failed(ResultMessage.UPDATE_FAILED);
        } else {
            return ResultUtils.success(ResultMessage.UPDATE_SUCCESS);
        }
    }

    @ApiOperation("根据查询条件分页查询新闻列表")
    @GetMapping("/listNews")
    public CommonDataResult<CommonPage<News>> listNews(@RequestParam(defaultValue = "1") Integer page,
                                                       @RequestParam(defaultValue = "20") Integer size,
                                                       @RequestParam @NotBlank String keyword) {
        return ResultUtils.success(ResultMessage.QUERY_SUCCESS, newsService.listNews(page, size, keyword));
    }

}
