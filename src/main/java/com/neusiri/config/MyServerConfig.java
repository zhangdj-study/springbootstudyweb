package com.neusiri.config;

import com.neusiri.component.MyFilter;
import com.neusiri.component.MyServlet;
import com.neusiri.component.MyServletRequestListener;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangdj
 * @date 2020-06-16 15:53
 * 服务器相关配置写到这里
 */
@Configuration
public class MyServerConfig {


    /**
     * 注册请求监听器
     */
//    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
        return new ServletListenerRegistrationBean(new MyServletRequestListener());
    }

    /**
     * 注册过滤器
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        // 指定拦截的请求
        filterRegistrationBean.addUrlPatterns("/myServlet","/hello");
        return filterRegistrationBean;
    }

    /**
     * 注册servlet
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        // 请求myServlet 会进入到MyServlet中
        return new ServletRegistrationBean(new MyServlet(),"/myServlet");
    }

    /**
     * 定制的servlet容器
     * @return
     */
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.setPort(8181);
            }
        };
    }
}
