package com.young.zrszt.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/19 11:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "通用分页")
public class CommonPage<T> {

    /**
     * 当前页码
     */
    private Integer page;

    /**
     * 每页展示数量
     */
    private Integer pageSize;

    /**
     * 最大页码
     */
    private Integer pages;

    /**
     * 数据总量
     */
    private Long total;

    /**
     * 当前页装载数据
     */
    private List<T> listData;

    public CommonPage(Integer page, Integer pageSize, List<T> listData) {
        this.page = page;
        this.pageSize = pageSize;
        this.pages = page;
        this.total = (long) pageSize;
        this.listData = listData;
    }

    /**
     * 将PageHelper分页后的list转为分页信息
     */
    public static <T> CommonPage<T> convertPage(Integer pageNum, Integer pageSize, List<T> list) {
        return new CommonPage<T>(
                pageNum,
                pageSize,
                list.size() % pageSize == 0 ? list.size() / pageSize : list.size() / pageSize + 1,
                (long) list.size(),
                list);
    }
}
