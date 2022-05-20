package com.young.zrszt.service;

import com.young.zrszt.common.CommonPage;
import com.young.zrszt.entity.News;
import com.young.zrszt.vo.CommonIdVo;
import com.young.zrszt.vo.NewsVo;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/17 18:10
 */
public interface NewsService {

    /**
     * 根据新闻ID返回新闻详情
     *
     * @param commonIdVo 新闻ID视图对象
     * @return 新闻详情
     */
    News selectNewsById(CommonIdVo commonIdVo);

    /**
     * 根据ID删除新闻
     *
     * @param commonIdVo 新闻ID视图对象
     * @return 删除结果
     */
    Integer delete(CommonIdVo commonIdVo);

    /**
     * 根据ID创建新闻
     *
     * @param newsVo 新闻
     * @return 创建结果
     */
    Integer create(NewsVo newsVo);

    /**
     * 根据ID修改新闻
     *
     * @param newsVo 新闻
     * @return 修改结果
     */
    Integer update(NewsVo newsVo);

    /**
     * 根据查询条件分页查询新闻列表
     *
     * @param page    页码
     * @param size    数量
     * @param keyword 关键字
     * @return 新闻列表
     */
    CommonPage<News> listNews(Integer page, Integer size, String keyword);


}
