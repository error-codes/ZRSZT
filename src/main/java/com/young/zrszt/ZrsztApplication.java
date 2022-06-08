package com.young.zrszt;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author SailorMoon
 */
@SpringBootApplication
@EnableOpenApi
@EnableKnife4j
public class ZrsztApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZrsztApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
