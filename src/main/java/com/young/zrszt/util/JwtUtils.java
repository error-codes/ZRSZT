package com.young.zrszt.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.young.zrszt.entity.User;
import com.young.zrszt.entity.YcrUserDetails;
import com.young.zrszt.enums.Channel;
import com.young.zrszt.mapper.YcrUserDetailsMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/30 15:56
 */
public class JwtUtils {

    /*********************************************
     *                                           *
     *              token  相关信息               *
     *                                           *
     ********************************************/
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_ISS = "baymax";
    public static final String TOKEN_SECRET = "my-best-love-ycr";
    public static final Long TOKEN_EXPIRATION = 604800L;

    public static String createToken(YcrUserDetails userDetails) {

        return Jwts.builder()
                .claim("user_info", userDetails)
                .signWith(SignatureAlgorithm.HS512, TOKEN_SECRET)
                .setIssuer(TOKEN_ISS)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(DateTimeUtils.LocalDateTimeToDate(LocalDateTime.now()))
                .setExpiration(DateTimeUtils.LocalDateTimeToDate(
                        DateTimeUtils.getCurDateAfterNumberChronoUnit(TOKEN_EXPIRATION, ChronoUnit.SECONDS)))
                .compact();
    }

    public static YcrUserDetails getUserFromToken(String token) {
        Map<String, Object> user_info = (Map<String, Object>) getTokenBody(token).get("user_info");
        return (YcrUserDetails) YcrUserDetailsMapper.INSTANCE.mapper(user_info);
    }

    public static boolean isExpiration(String token) {
        return getTokenBody(token).getExpiration().before(DateTimeUtils.LocalDateTimeToDate(LocalDateTime.now()));
    }

    public static Claims getTokenBody(String token) {
        return Jwts.parser()
                .setSigningKey(TOKEN_SECRET)
                .parseClaimsJws(token)
                .getBody();
    }
}
