package com.young.zrszt.service;

import com.young.zrszt.enums.CategoryEnum;
import com.young.zrszt.entity.SearchResponse;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/19 15:42
 */
public interface SearchService {

    /**
     * 根据关键字和查询类别搜索
     *
     * @param keyword    关键字
     * @param searchType 搜索类别
     * @return 搜索结果
     */
    SearchResponse search(String keyword, CategoryEnum searchType);
}
