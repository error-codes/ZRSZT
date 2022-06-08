package com.young.zrszt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/30 16:56
 */
@Configuration
@EnableWebSecurity
public class YcrSecurityConfig extends WebSecurityConfigurerAdapter {

    private final String[] release = new String[]{
            "/**.html",
            "/**.png",
            "/**.jpg",
            "/**.js",
            "/**.css",
            "/swagger**/**",
            "/webjars/**",
            "/v3/**",
            "/**",
            "/doc.html"
    };

    private final String[] notRelease = new String[]{

    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()
                .usernameParameter("username")
                .passwordParameter("password");

        http.authorizeRequests()
                .antMatchers(release).permitAll();

        http.authorizeRequests()
                .anyRequest()
                .authenticated();

//        http.exceptionHandling()
//                .authenticationEntryPoint(youngEntryPointHandler)
//                .accessDeniedHandler(youngAccessDeniedHandler);
//
//        http.logout()
//                .logoutUrl("/user/logout")
//                .logoutSuccessHandler(youngLogoutSuccessHandler)
//                .clearAuthentication(true)
//                .invalidateHttpSession(true)
//                .deleteCookies("JSESSIONID");

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.csrf().disable();

        http.cors();
    }

}
