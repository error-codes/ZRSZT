package com.young.zrszt.mapper;

import com.young.zrszt.entity.Collect;
import com.young.zrszt.vo.CollectVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/19 10:33
 */
@Mapper
public interface CollectMapper {

    /**
     * 收藏新闻
     *
     * @param collect 收藏详情
     * @return 收藏结果
     */
    Integer collect(Collect collect);

    /**
     * 取消收藏新闻
     *
     * @param collectId 收藏ID
     * @return 取消收藏结果
     */
    Integer unCollect(Long collectId);

    /**
     * 查找收藏ID
     *
     * @param entityId 收藏实体ID
     * @param userId   用户ID
     * @param category 实体类别
     * @return 收藏ID
     */
    Long selectCollect(Long entityId, Long userId, Integer category);
}
