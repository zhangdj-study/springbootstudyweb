package com.neusiri.component;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

/**
 * @author zhangdj
 * @date 2020-06-16 10:37
 * 自定义错误属性设置 集成DefaultErrorAttributes类
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    /**
     * 页面上最终可以获取的值
     * @param requestAttributes
     * @param includeStackTrace
     * @return
     */
    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        //调用父类的方法
        Map<String, Object> map = super.getErrorAttributes(requestAttributes, includeStackTrace);
        // 添加自定义的值
        map.put("company","neusiri");
        //从request域中获取之前存入的数据
        Map exceptionHandleData = (Map) requestAttributes.getAttribute("handleData",RequestAttributes.SCOPE_REQUEST);
        map.put("exceptionHandleData",exceptionHandleData);
        return map;
    }
}
