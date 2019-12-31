package com.neusiri.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author zhangdj
 * @date 2019/11/19
 */
@RestController
@Slf4j
public class HelloController {

    @GetMapping("hello")
    public String hello() {
        return "hello world";
    }

    @PostMapping("success")
    public String success(Map<String, Object> map) {
        map.put("person", "任务");
        // classpath:templates/success.html
        return "success";
    }

    @PostMapping("httpTest")
    public void httpTest(HttpServletResponse response, HttpServletRequest request, @RequestBody String sss) throws Exception{
        //创建一个字符串来存储请求信息
        StringBuffer req = new StringBuffer();
        //获取请求行
        //获取请求方法，URI，HTTP版本
        req.append(request.getMethod() + " " + request.getRequestURI() + " " + request.getProtocol() + "\n");
        log.info("-----------------");
        log.info(req.toString());
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String s = headerNames.nextElement();
            String header = request.getHeader(s);
            System.out.println(s + "---" + header);
        }
        System.out.println("-------------");
        ServletInputStream inputStream = request.getInputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(bytes)) != -1 ){
            String s = new String(bytes, 0, len);
            System.out.println(s);
        }
    }
}