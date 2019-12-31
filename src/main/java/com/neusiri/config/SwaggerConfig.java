package com.neusiri.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zhangdj
 * @date 2019/11/19
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * swagger包扫描
     */
    private static final String PACKAGE = "com.neusiri.controller";

    @Bean
    public Docket createRestApi() {
        // 返回swagger设置
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage(PACKAGE)).paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        // 返回api信息
        return new ApiInfoBuilder().title("Spring Boot中使用Swagger2构建RESTful APIs").description("demo")
                .termsOfServiceUrl("http://www.baidu.com").version("1.0").build();
    }
}
