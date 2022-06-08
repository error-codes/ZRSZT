package com.young.zrszt.mapper;

import com.young.zrszt.entity.SearchHistory;
import com.young.zrszt.vo.SearchHistoryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author error-codes【BayMax】
 * @description
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/6/4 17:53
 */
@Mapper
public interface SearchMapper {

    /**
     * 根据ID查找搜索历史
     *
     * @param searchHistoryVo 搜索历史视图对象
     * @return 搜索历史
     */
    SearchHistory selectBrowseHistoryByKeyword(SearchHistoryVo searchHistoryVo);

    /**
     * 展示搜索历史列表
     *
     * @param userId 用户ID
     * @return 搜索历史
     */
    List<SearchHistory> listBrowseHistory(Long userId);

    /**
     * 删除搜索历史
     *
     * @param searchHistoryId 搜索历史ID
     * @return 删除结果
     */
    Integer deleteBrowseHistory(Long searchHistoryId);

    /**
     * 新增搜索历史
     *
     * @param searchHistory 搜索历史实体
     * @return 删除结果
     */
    Integer addBrowseHistory(SearchHistory searchHistory);

    /**
     * 修改搜索历史
     *
     * @param searchHistoryId 搜索历史ID
     * @return 删除结果
     */
    Integer updateBrowseHistory(Long searchHistoryId);
}
