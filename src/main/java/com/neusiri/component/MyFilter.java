package com.neusiri.component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author zhangdj
 * @date 2020-06-16 16:01
 * 自定义拦截器
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("my filter processing");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
