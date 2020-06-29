package com.neusiri.config;

import com.neusiri.component.MyLocaleResolver;
import com.neusiri.component.MyWebMvcConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author zhangdj
 * @date 2019/11/25
 * 阿萨
 */
@Configuration
//@EnableWebMvc
public class MyWebMvcConfig {

    /**
     * 容器中添加自定义的mvc配置
     * @return
     */
    @Bean
    public WebMvcConfigurerAdapter mvcConfigurerAdapter(){
        return new MyWebMvcConfigurerAdapter();
    }

    /**
     * 容器中添加自定义的区域解析器
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

}
