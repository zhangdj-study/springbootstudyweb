package com.neusiri.component;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author zhangdj
 * @date 2020-06-12 15:52
 * 自定义webMvc配置
 */
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //请求configTest 来到success
        registry.addViewController("configTest").setViewName("success");
        registry.addViewController("/").setViewName("success");
        registry.addViewController("/index.html").setViewName("success");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/login");
    }
}
