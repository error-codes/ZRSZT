package com.young.zrszt.service;

import com.young.zrszt.common.CommonPage;
import com.young.zrszt.entity.CountryStandard;
import com.young.zrszt.entity.GroupStandard;
import com.young.zrszt.entity.IndustryStandard;
import com.young.zrszt.entity.LocalStandard;
import com.young.zrszt.enums.*;
import com.young.zrszt.vo.CountryStandardVo;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/25 19:08
 */
public interface StandardService {

    /**
     * 查找国家标准
     *
     * @param page      页码
     * @param size      数量
     * @param drafters  国标计划
     * @param plans     国家计划
     * @param publicity 拟立项总体分布
     * @param dateKind  时间
     * @param status    项目状态
     * @return 国家标准
     */
    CommonPage<CountryStandard> selectCountryStandard(Integer page, Integer size, List<Drafter> drafters, List<Plan> plans, List<Publicity> publicity, DateKind dateKind, ProjectStatus status);

    /**
     * 查找地方标准
     *
     * @param page     页码
     * @param size     数量
     * @param province 省份
     * @param dateKind 时间
     * @return 地方标准
     */
    CommonPage<LocalStandard> selectLocalStandard(Integer page, Integer size, List<Province> province, DateKind dateKind);

    /**
     * 查找行业标准
     *
     * @param page     页码
     * @param size     数量
     * @param organs   部门机关
     * @param sectors  行业领域
     * @param dateKind 时间
     * @return 行业标准
     */
    CommonPage<IndustryStandard> selectIndustryStandard(Integer page, Integer size, List<Organ> organs, List<IndustrySector> sectors, DateKind dateKind);

    /**
     * 查找团体标准
     *
     * @param page     页码
     * @param size     数量
     * @param industry 行业
     * @param status   标准状态
     * @param sell     出售状态
     * @param open     公开状态
     * @return 团体标准
     */
    CommonPage<GroupStandard> selectGroupStandard(Integer page, Integer size, Industry industry, Boolean status, Boolean sell, Boolean open);
}
