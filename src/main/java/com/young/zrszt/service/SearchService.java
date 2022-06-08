package com.young.zrszt.service;

import com.young.zrszt.common.CommonPage;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/19 15:42
 */
public interface SearchService {

    /**
     * 根据关键字和查询类别搜索
     *
     * @param userId  用户ID
     * @param keyword 关键字
     * @return 搜索结果
     */
    CommonPage<?> search(Long userId, String keyword);
}
