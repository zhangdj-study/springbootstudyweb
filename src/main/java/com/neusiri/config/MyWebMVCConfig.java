package com.neusiri.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author zhangdj
 * @date 2019/11/25
 */
@Configuration
//@EnableWebMvc
public class MyWebMVCConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //请求configTest 来到success
        registry.addViewController("configTest").setViewName("success");
    }
}
