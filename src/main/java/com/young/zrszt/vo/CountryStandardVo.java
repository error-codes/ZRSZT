package com.young.zrszt.vo;

import com.young.zrszt.enums.*;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author error-codes【BayMax】
 * @description
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/6/4 22:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("国家标准视图对象")
public class CountryStandardVo {

    private List<Drafter> drafter;

    private List<Plan> plan;

    private List<Publicity> publicity;

    private DateKind dateKind;

    private ProjectStatus projectStatus;
}

