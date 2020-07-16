package com.neusiri.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author zhangdj
 * @date 2020-07-15 16:09
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 请求/ 需要v1角色 请求user/queryById/**需要v2角色
        http.authorizeRequests()
                .antMatchers("/").hasRole("v1")
                .antMatchers("/user/queryById/**").hasRole("v2");
        // /login来到登录页  登录失败会重定向到/login?error
        http.formLogin();
        // 注销 清空session 默认跳转到login
        // http.logout().logoutSuccessUrl() 注销成功 跳转的url
        http.logout();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 给用户授权
        auth.inMemoryAuthentication()
                .withUser("zhangsan").password("123456").roles("v2")
                .and()
                .withUser("lisi").password("123456").roles("v1");
    }
}
