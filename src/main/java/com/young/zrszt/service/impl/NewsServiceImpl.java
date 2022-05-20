package com.young.zrszt.service.impl;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.Result;
import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.young.zrszt.common.CommonPage;
import com.young.zrszt.entity.News;
import com.young.zrszt.mapper.CollectMapper;
import com.young.zrszt.service.NewsService;
import com.young.zrszt.util.SnowFlakeUtils;
import com.young.zrszt.vo.CommonIdVo;
import com.young.zrszt.vo.NewsVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/19 10:37
 */
@Service("elasticSearchService")
public class NewsServiceImpl implements NewsService {

    private final ElasticsearchClient elasticsearchClient;
    private final String INDEX_NAME = "news";

    @Autowired
    public NewsServiceImpl(ElasticsearchClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }

    @Override
    public News selectNewsById(CommonIdVo commonIdVo) {
        if (!existsIndex(INDEX_NAME)) {
            return null;
        }

        GetRequest getRequest = new GetRequest.Builder()
                .index(INDEX_NAME)
                .id(String.valueOf(commonIdVo.getId()))
                .build();

        try {
            GetResponse<News> getResponse = elasticsearchClient.get(getRequest, News.class);
            return getResponse.source();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer delete(CommonIdVo commonIdVo) {
        if (!existsIndex(INDEX_NAME)) {
            return null;
        }

        DeleteRequest deleteRequest = new DeleteRequest.Builder()
                .index(INDEX_NAME)
                .id(String.valueOf(commonIdVo.getId()))
                .build();

        try {
            DeleteResponse deleteResponse = elasticsearchClient.delete(deleteRequest);
            if (deleteResponse.result() == Result.Deleted) {
                return 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Integer create(NewsVo newsVo) {
        if (!existsIndex(INDEX_NAME)) {
            return null;
        }

        long newsId = SnowFlakeUtils.getSnowFlakeId();
        News news = new News();
        BeanUtils.copyProperties(newsVo, news);
        news.setId(newsId);

        CreateRequest<News> createRequest = new CreateRequest.Builder<News>()
                .index(INDEX_NAME)
                .id(String.valueOf(newsId))
                .document(news)
                .build();

        try {
            CreateResponse createResponse = elasticsearchClient.create(createRequest);
            if (createResponse.result() == Result.Created) {
                return 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Integer update(NewsVo newsVo) {
        if (!existsIndex(INDEX_NAME)) {
            return null;
        }

        UpdateRequest<News, NewsVo> updateRequest = new UpdateRequest.Builder<News, NewsVo>()
                .index(INDEX_NAME)
                .id(String.valueOf(newsVo.getId()))
                .doc(newsVo)
                .build();

        try {
            UpdateResponse<News> updateResponse = elasticsearchClient.update(updateRequest, News.class);
            if (updateResponse.result() == Result.Updated) {
                return 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public CommonPage<News> listNews(Integer page, Integer size, String keyword) {
        if (!existsIndex(INDEX_NAME)) {
            return null;
        }

        SearchRequest searchRequest = new SearchRequest.Builder()
                .index(INDEX_NAME)
                .query(QueryBuilders.multiMatch()
                        .fields("content", "title", "company", "media")
                        .query(keyword).build()._toQuery())
                .from(page - 1)
                .size(size)
                .sort(sort -> sort.field(field -> field.field("releaseTime").order(SortOrder.Desc))).build();

        try {
            SearchResponse<News> searchResponse = elasticsearchClient.search(searchRequest, News.class);
            List<News> newsList = searchResponse.hits().hits().stream().map(Hit::source).collect(Collectors.toList());
            return new CommonPage<>(page, size, newsList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean existsDocument(String uuid, String index) {
        ExistsRequest existsRequest = new ExistsRequest.Builder()
                .index(index)
                .id(uuid).build();

        try {
            return elasticsearchClient.exists(existsRequest).value();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean existsIndex(String index) {
        co.elastic.clients.elasticsearch.indices.ExistsRequest indexRequest = new co.elastic.clients.elasticsearch.indices.ExistsRequest.Builder()
                .index(index).build();
        try {
            return elasticsearchClient.indices().exists(indexRequest).value();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
