package com.young.zrszt.service.impl;

import com.young.zrszt.enums.CategoryEnum;
import com.young.zrszt.entity.SearchResponse;
import com.young.zrszt.service.SearchService;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/19 15:53
 */
public class SearchServiceImpl implements SearchService {

    @Override
    public SearchResponse search(String keyword, CategoryEnum searchType) {
        switch (searchType) {
            case NEWS:
                return null;
            case COMPANY:
                return null;
            case STATUTE:
                return null;
            case STANDARD:
                return null;
            default:
                return null;
        }
    }
}
