package com.young.zrszt.service;

import com.young.zrszt.common.CommonPage;
import com.young.zrszt.entity.SearchHistory;
import com.young.zrszt.vo.CommonIdVo;
import com.young.zrszt.vo.SearchHistoryVo;

/**
 * @author SailorMoon
 */
public interface SearchHistoryService {

    /**
     * 展示搜索历史列表
     *
     * @param page 页码
     * @param size 单页负载量
     * @param userId 用户ID
     * @return 搜索历史
     */
    CommonPage<SearchHistory> listBrowseHistory(Integer page, Integer size, Long userId);

    /**
     * 删除搜索历史
     *
     * @param commonIdVo 通用ID视图对象
     * @return 删除结果
     */
    Integer deleteBrowseHistory(CommonIdVo commonIdVo);

    /**
     * 新增搜索历史
     *
     * @param searchHistoryVo 搜索历史视图对象
     * @return 删除结果
     */
    Integer addBrowseHistory(SearchHistoryVo searchHistoryVo);
}
