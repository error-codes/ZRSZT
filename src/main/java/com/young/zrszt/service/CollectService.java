package com.young.zrszt.service;

import com.young.zrszt.enums.CategoryEnum;
import com.young.zrszt.vo.CollectVo;
import com.young.zrszt.vo.CommonIdVo;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/19 18:05
 */
public interface CollectService {

    /**
     * 收藏对应类别实体
     *
     * @param collectVo 收藏视图对象
     * @return 收藏结果
     */
    Integer collect(CollectVo collectVo);

    /**
     * 取消收藏新闻
     *
     * @param commonIdVo 收藏ID视图对象
     * @return 取消收藏结果
     */
    Integer unCollect(CommonIdVo commonIdVo);
}
