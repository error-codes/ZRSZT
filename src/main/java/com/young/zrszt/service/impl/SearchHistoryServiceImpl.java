package com.young.zrszt.service.impl;

import com.young.zrszt.common.CommonPage;
import com.young.zrszt.entity.SearchHistory;
import com.young.zrszt.mapper.SearchMapper;
import com.young.zrszt.service.SearchHistoryService;
import com.young.zrszt.util.DateTimeUtils;
import com.young.zrszt.util.SnowFlakeUtils;
import com.young.zrszt.vo.CommonIdVo;
import com.young.zrszt.vo.SearchHistoryVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author SailorMoon
 */
@Service("searchHistoryService")
public class SearchHistoryServiceImpl implements SearchHistoryService {

    @Resource
    private SearchMapper searchMapper;

    @Override
    public CommonPage<SearchHistory> listBrowseHistory(Integer page, Integer size, Long userId) {
        return new CommonPage<>(page, size, searchMapper.listBrowseHistory(userId));
    }

    @Override
    public Integer deleteBrowseHistory(CommonIdVo commonIdVo) {
        return searchMapper.deleteBrowseHistory(commonIdVo.getId());
    }

    @Override
    public Integer addBrowseHistory(SearchHistoryVo searchHistoryVo) {
        SearchHistory searchHistory = searchMapper.selectBrowseHistoryByKeyword(searchHistoryVo);
        if (searchHistory == null) {
            searchHistory = new SearchHistory(
                    SnowFlakeUtils.getSnowFlakeId(),
                    searchHistoryVo.getUserId(),
                    searchHistoryVo.getKeyword(),
                    DateTimeUtils.getCurrentLocalDateTime()
            );
            return searchMapper.addBrowseHistory(searchHistory);
        } else {
            return searchMapper.updateBrowseHistory(searchHistory.getHistoryId());
        }
    }
}
