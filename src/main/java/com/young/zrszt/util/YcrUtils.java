package com.young.zrszt.util;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.ExistsRequest;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/30 14:51
 */
@Component
public class YcrUtils {

    private static ElasticsearchClient elasticsearchClient;

    @Autowired
    public YcrUtils(ElasticsearchClient elasticsearchClient) {
        YcrUtils.elasticsearchClient = elasticsearchClient;
    }

    public static String generateVerifyCode() {
        return generateRandomNum(6);
    }

    private static String generateRandomNum(Integer length) {
        StringBuilder zero = new StringBuilder();
        for (int i = 0; i < length - 1; i++) {
            zero.append("0");
        }
        int start = Integer.parseInt("1" + zero);
        int end = Integer.parseInt("10" + zero) - 1;

        return String.valueOf(RandomUtils.nextInt(start, end));
    }

    public static boolean existsDocument(String uuid, String index) {
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

    public static boolean existsIndex(String index) {
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
