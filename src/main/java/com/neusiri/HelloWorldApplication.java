package com.neusiri;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Locale;

/**
 * @author zhangdj
 * @date 2019/10/10
 * @EnableRabbit 开启rabbit监听模式
 * @EnableAsync 开启异步注解
 * @EnableScheduling 开启定时任务注解
 */
@SpringBootApplication
@EnableSwagger2
//@ComponentScan({"com.neusiri"})
//@MapperScan({"com.neusiri.mapper"})
@EnableRabbit
@EnableCaching
@EnableAsync
@EnableScheduling
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
