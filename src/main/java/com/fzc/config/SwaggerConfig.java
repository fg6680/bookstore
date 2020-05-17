package com.fzc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author fzc
 * @since 2020-05-13 11:24:58
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("辰")
                .apiInfo(apiInfo())
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fzc.controller"))  //添加ApiOperiation注解的被扫描
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("Fengzichen", "https://github.com/fg6680/bookstore", "zichenfeng@yahoo.com");
        return new ApiInfoBuilder()
                .title(" 冯子辰的Swagger API接口文档")
                .description("感觉到了的东西，我们无法立刻去理解它；只有理解了的东西，我们才能深刻地感觉它")
                .contact(contact)
                .version("v1.0")
                .build();

    }
}
