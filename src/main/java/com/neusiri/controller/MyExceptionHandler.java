package com.neusiri.controller;

import com.neusiri.exception.HelloException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangdj
 * @date 2020-06-15 17:24
 * 自定义异常处理器
 */
@ControllerAdvice
public class MyExceptionHandler {

    /**
     * 处理HelloException这个异常 响应json数据
     * @return
     */
//    @ExceptionHandler(HelloException.class)
//    @ResponseBody
//    public Map helloHandler(Exception e){
//        Map map = new HashMap(10);
//        map.put("code",555);
//        map.put("message",e.getMessage());
//        return map;
//    }

    @ExceptionHandler(HelloException.class)
    public String helloHandler(Exception e, HttpServletRequest request){
/*        Integer statusCode = (Integer) request
                .getAttribute("javax.servlet.error.status_code");*/
        //设置请求错误码
        request.setAttribute("javax.servlet.error.status_code",500);
        Map map = new HashMap(10);
        map.put("code",555);
        map.put("message",e.getMessage());
        //放到request域中
        request.setAttribute("handleData",map);
        //转发到error请求 由SpringBoot帮我们做自适应
        return "forward:/error";
    }
}
