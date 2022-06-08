package com.young.zrszt.mapper;

import com.young.zrszt.entity.YcrUserDetails;
import com.young.zrszt.enums.Channel;
import org.mapstruct.*;
import org.mapstruct.control.DeepClone;
import org.mapstruct.factory.Mappers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/6/1 10:27
 */
@Mapper
public interface YcrUserDetailsMapper {

    YcrUserDetailsMapper INSTANCE = Mappers.getMapper(YcrUserDetailsMapper.class);

    /**
     * 深拷贝
     *
     * @param map
     * @return
     */
    @Mapping(expression = "java((Long) map.get(\"userId\"))", target = "userId")
    @Mapping(expression = "java((String) map.get(\"nickName\"))", target = "nickName")
    @Mapping(expression = "java((String) map.get(\"avatar\"))", target = "avatar")
    @Mapping(expression = "java((String) map.get(\"phone\"))", target = "phone")
    @Mapping(target = "authorities", ignore = true)
    @Mapping(target = "channels", ignore = true)
    YcrUserDetails mapper(Map<String, Object> map);


    @AfterMapping
    default void finishYcrUserDetails(@MappingTarget YcrUserDetails userDetails, Map<String, Object> map) {
        userDetails.setChannels(stringToChannel((List<String>) map.get("channels")));
    }

    @Mapping(source = "channels", target = "channels")
    List<Channel> stringToChannel(List<String> channels);

}
