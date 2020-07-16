package com.neusiri.component;

import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author zhangdj
 * @date 2020-06-12 15:55
 */
public class MyInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle-----------");
//        returnErrorResponse(response,333,"被拦截了","233");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    private void returnErrorResponse(HttpServletResponse response, Integer code, String msg, String data)
            throws Exception {
        // 设置response编码格式
        response.setCharacterEncoding("UTF-8");
        // 设置response内容格式
        response.setContentType("application/json; charset=utf-8");
        // 定义 PrintWriter out
        PrintWriter out;
        // 定义JSONObject res
        JSONObject res = new JSONObject();
        // 跟系统公共返回response保持一致
        res.put("code", code);
        res.put("msg", msg);
        res.put("data", data);
        // 写入response
        out = response.getWriter();
        out.append(res.toString());
    }
}
