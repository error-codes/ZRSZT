package com.young.zrszt.config;

import com.fasterxml.classmate.TypeResolver;
import com.young.zrszt.entity.Statute;
import com.young.zrszt.enums.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/12 23:10
 */
@Configuration
public class SwaggerConfig {

    @Autowired
    private TypeResolver typeResolver;

    private Docket createSwagger() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.young.zrszt.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("中认数智通 API")
                .contact(new Contact(
                        "error-codes [BayMax]",
                        "https://www.error-codes.xyz",
                        "2309590834@qq.com"))
                .description("中认数智通 项目接口文档")
                .version("0.0.1-SNAPSHOT").build();
    }

    @Bean
    public Docket createRestApi() {
        return createSwagger();
    }
}
