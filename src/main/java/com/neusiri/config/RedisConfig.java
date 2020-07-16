package com.neusiri.config;

import com.neusiri.model.Department;
import com.neusiri.model.UserDO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

/**
 * @author zhangdj
 * @date 2020-07-09 20:00
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<Object, Object> myRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Object> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        // 自定义json序列化器需要指定泛型
        Jackson2JsonRedisSerializer<UserDO> serializer = new Jackson2JsonRedisSerializer(UserDO.class);
        // 设置默认序列化器
        template.setDefaultSerializer(serializer);
        return template;
    }

    /**
     * 自定义CacheManager
     * @param myRedisTemplate
     * @return
     */
    @Bean
    public RedisCacheManager myCacheManager(RedisTemplate<Object, Object> myRedisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(myRedisTemplate);
        // 默认会将cacheName作为key的前缀
        cacheManager.setUsePrefix(true);
        return cacheManager;
    }


    @Bean
    public RedisTemplate<Object, Object> departmentRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Object> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        // 自定义json序列化器需要指定泛型
        Jackson2JsonRedisSerializer<Department> serializer = new Jackson2JsonRedisSerializer(Department.class);
        // 设置默认序列化器
        template.setDefaultSerializer(serializer);
        return template;
    }

    /**
     * 自定义CacheManager
     * @param departmentRedisTemplate
     * @return
     */
    @Bean
    @Primary
    public RedisCacheManager departmentCacheManager(RedisTemplate<Object, Object> departmentRedisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(departmentRedisTemplate);
        // 默认会将cacheName作为key的前缀
        cacheManager.setUsePrefix(true);
        return cacheManager;
    }
}
