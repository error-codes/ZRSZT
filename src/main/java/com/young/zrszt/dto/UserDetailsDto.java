package com.young.zrszt.dto;

import com.young.zrszt.entity.User;
import com.young.zrszt.entity.YcrUserDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/30 22:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDto {

    private YcrUserDetails userDetails;

    private String token;

}
