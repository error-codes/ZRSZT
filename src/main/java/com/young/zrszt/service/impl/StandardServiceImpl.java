package com.young.zrszt.service.impl;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import co.elastic.clients.elasticsearch.core.GetRequest;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.young.zrszt.common.CommonPage;
import com.young.zrszt.dto.NewsDto;
import com.young.zrszt.entity.*;
import com.young.zrszt.enums.*;
import com.young.zrszt.service.CollectService;
import com.young.zrszt.service.StandardService;
import com.young.zrszt.vo.CollectVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.young.zrszt.util.YcrUtils.existsIndex;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/29 12:47
 */
@Service("standardService")
public class StandardServiceImpl implements StandardService {

    private final ElasticsearchClient elasticsearchClient;
    private final String COUNTRY = "country_standard";
    private final String LOCAL = "local_standard";
    private final String INDUSTRY = "industry_standard";
    private final String GROUP = "group_standard";

    @Autowired
    public StandardServiceImpl(ElasticsearchClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }

    @Override
    public CommonPage<CountryStandard> selectCountryStandard(Integer page, Integer size, List<Drafter> drafters, List<Plan> plans, List<Publicity> publicity, DateKind dateKind, ProjectStatus status) {
        if (!existsIndex(COUNTRY)) {
            return null;
        }

        SearchRequest.Builder index = new SearchRequest.Builder()
                .index(COUNTRY);

        SearchRequest searchRequest = index
                .from(page - 1)
                .size(size)
                .sort(sort -> sort.field(field -> field.field("startDate").order(SortOrder.Desc))).build();

        try {
            SearchResponse<CountryStandard> searchResponse = elasticsearchClient.search(searchRequest, CountryStandard.class);
            List<CountryStandard> countryStandards = searchResponse.hits().hits().stream().map(Hit::source).collect(Collectors.toList());
            return new CommonPage<>(page, size, countryStandards);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CommonPage<LocalStandard> selectLocalStandard(Integer page, Integer size, List<Province> province, DateKind dateKind) {
        if (!existsIndex(LOCAL)) {
            return null;
        }

        SearchRequest.Builder index = new SearchRequest.Builder()
                .index(LOCAL);

        SearchRequest searchRequest = index
                .from(page - 1)
                .size(size)
                .sort(sort -> sort.field(field -> field.field("issueDate").order(SortOrder.Desc))).build();

        try {
            SearchResponse<LocalStandard> searchResponse = elasticsearchClient.search(searchRequest, LocalStandard.class);
            List<LocalStandard> localStandards = searchResponse.hits().hits().stream().map(Hit::source).collect(Collectors.toList());
            return new CommonPage<>(page, size, localStandards);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CommonPage<IndustryStandard> selectIndustryStandard(Integer page, Integer size, List<Organ> organs, List<IndustrySector> sectors, DateKind dateKind) {
        if (!existsIndex(INDUSTRY)) {
            return null;
        }

        SearchRequest.Builder index = new SearchRequest.Builder()
                .index(INDUSTRY);

        SearchRequest searchRequest = index
                .from(page - 1)
                .size(size)
                .sort(sort -> sort.field(field -> field.field("issueDate").order(SortOrder.Desc))).build();

        try {
            SearchResponse<IndustryStandard> searchResponse = elasticsearchClient.search(searchRequest, IndustryStandard.class);
            List<IndustryStandard> industryStandards = searchResponse.hits().hits().stream().map(Hit::source).collect(Collectors.toList());
            return new CommonPage<>(page, size, industryStandards);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CommonPage<GroupStandard> selectGroupStandard(Integer page, Integer size, Industry industry, Boolean status, Boolean sell, Boolean open) {
        if (!existsIndex(GROUP)) {
            return null;
        }

        SearchRequest.Builder index = new SearchRequest.Builder()
                .index(GROUP);

        SearchRequest searchRequest = index
                .from(page - 1)
                .size(size)
                .sort(sort -> sort.field(field -> field.field("issueDate").order(SortOrder.Desc))).build();

        try {
            SearchResponse<GroupStandard> searchResponse = elasticsearchClient.search(searchRequest, GroupStandard.class);
            List<GroupStandard> groupStandards = searchResponse.hits().hits().stream().map(Hit::source).collect(Collectors.toList());
            return new CommonPage<>(page, size, groupStandards);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
