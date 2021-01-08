package com.neusiri.controller;

import com.neusiri.exception.HelloException;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @author zhangdj
 * @date 2019/11/19
 */
@RestController
@Api(tags = {"http请求测试"})
@Slf4j
public class HelloController {

    @GetMapping("hello")
    public String hello(@RequestParam("hello") String hello) {
        if (!"hello".equals(hello)) {
            throw new HelloException();
        }
        return "hello world";
    }

    @PostMapping("success")
    public String success(Map<String, Object> map) {
        map.put("person", "任务");
        // classpath:templates/success.html
        return "success";
    }

    @PostMapping("httpTest")
    public void httpTest(HttpServletResponse response, HttpServletRequest request, @RequestBody String sss) throws Exception {
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
        while ((len = inputStream.read(bytes)) != -1) {
            String s = new String(bytes, 0, len);
            System.out.println(s);
        }
    }


    @GetMapping("/timeout")
    public Callable<String> timeout() {
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(10000); //this will cause a timeout
                return "接口Callable测试";
            }
        };
    }
}
