package com.neusiri.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author zhangdj
 * @date 2020-07-07 17:48
 *
 * 缓存配置
 */
@Configuration
public class CacheConfig {

    /**
     * 自定义key生成器
     * @return
     */
    @Bean
    public KeyGenerator myKeyGenerator(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return method.getName() + "{" + Arrays.asList(params).toString() + "}";
            }
        };
    }
}
