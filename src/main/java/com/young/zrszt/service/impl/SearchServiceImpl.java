package com.young.zrszt.service.impl;

import com.young.zrszt.common.CommonPage;
import com.young.zrszt.service.*;
import com.young.zrszt.vo.SearchHistoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/19 15:53
 */
@Service("searchService")
public class SearchServiceImpl implements SearchService {

    private NewsService newsService;
    private CompanyService companyService;
    private StatuteService statuteService;
    private StandardService standardService;
    private SearchHistoryService searchHistoryService;

    @Autowired
    public SearchServiceImpl(NewsService newsService, CompanyService companyService, StatuteService statuteService, StandardService standardService, SearchHistoryService searchHistoryService) {
        this.newsService = newsService;
        this.companyService = companyService;
        this.statuteService = statuteService;
        this.standardService = standardService;
        this.searchHistoryService = searchHistoryService;
    }

    @Override
    public CommonPage<?> search(Long userId, String keyword) {
        searchHistoryService.addBrowseHistory(new SearchHistoryVo(userId, keyword));
        return newsService.listNews(1, 20, null, userId, keyword);
    }
}
