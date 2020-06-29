package com.neusiri.component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * @author zhangdj
 * @date 2020-06-16 16:11
 * 自定义请求监听器 ServletRequestListener
 *
 */
public class MyServletRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("my listener destroy");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("my listener init");
    }
}
