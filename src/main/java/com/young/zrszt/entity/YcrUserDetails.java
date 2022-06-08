package com.young.zrszt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.young.zrszt.enums.Channel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/30 22:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class YcrUserDetails implements UserDetails {

    private Long userId;

    private String nickName;

    private String avatar;

    private String phone;

    private List<Channel> channels;

    @JsonIgnore
    private String username;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private Collection<? extends GrantedAuthority> authorities;
    @JsonIgnore
    private boolean accountNonExpired;
    @JsonIgnore
    private boolean accountNonLocked;
    @JsonIgnore
    private boolean credentialsNonExpired;
    @JsonIgnore
    private boolean enabled;

    public YcrUserDetails(Long userId, String nickName, String avatar, String phone, List<Channel> channels) {
        this.userId = userId;
        this.nickName = nickName;
        this.avatar = avatar;
        this.phone = phone;
        this.channels = channels;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.phone;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
