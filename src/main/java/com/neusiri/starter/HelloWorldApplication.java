package com.neusiri.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Locale;

/**
 * @author zhangdj
 * @date 2019/10/10
 */
@SpringBootApplication
@EnableSwagger2
@ComponentScan({"com.neusiri.controller","com.neusiri.config"})
public class HelloWorldApplication {
    public static void main(String[] args) {
        //启动
        SpringApplication.run(HelloWorldApplication.class,args);
    }

    @Bean
    public ViewResolver my(){
        return new MyViewResolver();
    }

    class MyViewResolver implements ViewResolver{

        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }
}
