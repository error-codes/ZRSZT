package com.young.zrszt.controller;

import com.young.zrszt.common.CommonDataResult;
import com.young.zrszt.common.CommonPage;
import com.young.zrszt.entity.*;
import com.young.zrszt.enums.*;
import com.young.zrszt.service.NewsService;
import com.young.zrszt.service.StandardService;
import com.young.zrszt.util.ResultUtils;
import com.young.zrszt.vo.CommonIdVo;
import io.swagger.annotations.*;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author SailorMoon
 */
@RestController
@RequestMapping("/standard")
@Api(tags = "标准接口")
public class StandardController {

    private final StandardService standardService;

    @Autowired
    public StandardController(StandardService standardService) {
        this.standardService = standardService;
    }

    @ApiOperation("国家标准高级检索")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码"),
            @ApiImplicitParam(name = "size", value = "单页负载数据量"),
            @ApiImplicitParam(name = "drafters", value = "国标计划", allowMultiple = true, dataTypeClass = Drafter.class),
            @ApiImplicitParam(name = "plans", value = "国家计划", allowMultiple = true, dataTypeClass = Plan.class),
            @ApiImplicitParam(name = "publicity", value = "拟立项总体分布", allowMultiple = true, dataTypeClass = Publicity.class),
            @ApiImplicitParam(name = "dateKind", value = "时间", dataType = "DateKind"),
            @ApiImplicitParam(name = "status", value = "项目状态", dataType = "ProjectStatus")
    })
    @GetMapping("/country")
    public CommonDataResult<CommonPage<CountryStandard>> selectCountryStandard(@RequestParam(defaultValue = "1") Integer page,
                                                                               @RequestParam(defaultValue = "20") Integer size,
                                                                               @RequestParam(required = false) List<Drafter> drafters,
                                                                               @RequestParam(required = false) List<Plan> plans,
                                                                               @RequestParam(required = false) List<Publicity> publicity,
                                                                               @RequestParam(required = false) DateKind dateKind,
                                                                               @RequestParam(required = false) ProjectStatus status) {
        return ResultUtils.success(standardService.selectCountryStandard(page, size, drafters, plans, publicity, dateKind, status));
    }

    @ApiOperation("地区标准高级检索")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码"),
            @ApiImplicitParam(name = "size", value = "单页负载数据量"),
            @ApiImplicitParam(name = "province", value = "地区", allowMultiple = true, dataTypeClass = Province.class),
            @ApiImplicitParam(name = "dateKind", value = "时间", dataType = "DateKind")
    })
    @GetMapping("/local")
    public CommonDataResult<CommonPage<LocalStandard>> selectLocalStandard(@RequestParam(defaultValue = "1") Integer page,
                                                                           @RequestParam(defaultValue = "20") Integer size,
                                                                           @RequestParam(required = false) List<Province> province,
                                                                           @RequestParam(required = false) DateKind dateKind) {
        return ResultUtils.success(standardService.selectLocalStandard(page, size, province, dateKind));
    }

    @ApiOperation("行业标准高级检索")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码"),
            @ApiImplicitParam(name = "size", value = "单页负载数据量"),
            @ApiImplicitParam(name = "organs", value = "部门机关", allowMultiple = true, dataTypeClass = Organ.class),
            @ApiImplicitParam(name = "sectors", value = "行业领域", allowMultiple = true, dataTypeClass = IndustrySector.class),
            @ApiImplicitParam(name = "dateKind", value = "时间", dataType = "DateKind")
    })
    @GetMapping("/industry")
    public CommonDataResult<CommonPage<IndustryStandard>> selectIndustryStandard(@RequestParam(defaultValue = "1") Integer page,
                                                                                 @RequestParam(defaultValue = "20") Integer size,
                                                                                 @RequestParam(required = false) List<Organ> organs,
                                                                                 @RequestParam(required = false) List<IndustrySector> sectors,
                                                                                 @RequestParam(required = false) DateKind dateKind) {
        return ResultUtils.success(standardService.selectIndustryStandard(page, size, organs, sectors, dateKind));
    }

    @ApiOperation("团体标准高级检索")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码"),
            @ApiImplicitParam(name = "size", value = "单页负载数据量"),
            @ApiImplicitParam(name = "industry", value = "行业", dataType = "Industry"),
            @ApiImplicitParam(name = "status", value = "标准状态", dataType = "Boolean"),
            @ApiImplicitParam(name = "sell", value = "是否出售", dataType = "Boolean"),
            @ApiImplicitParam(name = "open", value = "是否公开", dataType = "Boolean")
    })
    @GetMapping("/group")
    public CommonDataResult<CommonPage<GroupStandard>> selectGroupStandard(@RequestParam(defaultValue = "1") Integer page,
                                                                           @RequestParam(defaultValue = "20") Integer size,
                                                                           @RequestParam(required = false) Industry industry,
                                                                           @RequestParam(required = false) Boolean status,
                                                                           @RequestParam(required = false) Boolean sell,
                                                                           @RequestParam(required = false) Boolean open) {
        return ResultUtils.success(standardService.selectGroupStandard(page, size, industry, status, sell, open));
    }
}
