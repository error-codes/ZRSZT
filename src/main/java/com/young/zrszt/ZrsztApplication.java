package com.young.zrszt;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
@EnableKnife4j
public class ZrsztApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZrsztApplication.class, args);
    }

}
