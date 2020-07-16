package com.neusiri.service;

import com.alibaba.fastjson.JSONObject;
import com.neusiri.mapper.UserMapper;
import com.neusiri.model.UserDO;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @CacheConfig(cacheNames = "user")
 * 抽取公共配置
 * @author zhangdj
 * @date 2020-07-06 15:22
 */
@Service
@CacheConfig(cacheNames = "user",cacheManager = "myCacheManager")
public class UserService {

    private UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * @param id
     * @return
     * @Cacheable 将结果存入缓存中，以后要相同的数据直接从缓存中获取
     * cacheNames/value：缓存组件的名字（每个缓存组件都有自己的名字）
     * key：缓存使用的key 默认使用的是参数的值
     * 可以使用SpEL编写
     * keyGenerator：key的生成器  与key二选一
     * cacheManager：指定缓存管理器；或者使用cacheResolver获取
     * condition：指定条件，条件符合才会缓存；
     * unless：与condition相反，条件符合不会缓存，可以获取到结果进行判断
     * sync：是否使用异步模式
     * <p>
     * <p>
     * key = "#root.methodName + '[' + #id + ']'" 指定key为 queryById[id]
     * <p>
     * condition = "#id > 1" 参数中的id大于1会缓存
     * unless = "#id == 3" 参数中的id等于3不会缓存
     * <p>
     * 使用自定义key生成器 值为bean的名称
     * keyGenerator = "myKeyGenerator",condition = "#id > 1",unless = "#id == 3"
     */
//    @Cacheable(cacheNames = "user")
    public UserDO queryById(Long id) {
        return userMapper.queryById(id);
    }

    /**
     * @param userDO
     * @return
     * @CachePut 方法执行完成后将结果放入到缓存中，修改完成后要想同步更新缓存，缓存组件和key必须要和查询的相同
     */
    @CachePut(cacheNames = "user", key = "#userDO.id")
    public UserDO update(UserDO userDO) {
        userMapper.update(userDO);
        return userDO;
    }

    /**
     * @CacheEvict 清除缓存
     *      默认按照key清除对应的缓存，allEntries = true可以清除全部的缓存数据
     *      默认是在执行方法之后清除缓存，beforeInvocation = true可以指定在方法之前执行缓存
     *      执行方法之后清除缓存：如果方法出现异常则不会清除缓存
     *      执行方法之前清除缓存：如果方法出现异常也会清除缓存
     *
     *
     *      key = "#id"
     * @param id
     */
    @CacheEvict(cacheNames = "user",allEntries = true,beforeInvocation = true)
    public void delete(Long id) {
        System.out.println("delete " + id);
        throw new RuntimeException();
    }

    /**
     * @Caching 用于设置复杂缓存规则
     * @param name
     * @return
     */
    @Caching(
            cacheable = {
                    @Cacheable(/*value = "user",*/key = "#name")
            },
            put = {
                    @CachePut(/*value = "user",*/key = "#result.id"),
                    @CachePut(/*value = "user",*/key = "#name")
            }
    )
    public UserDO getByName(String name){
        return userMapper.getByName(name);
    }

    /**
     * 监听neusiri这个队列
     * @param map
     */
    @RabbitListener(queues = {"neusiri"})
    public void getMessage(Map map){
        System.out.println("收到消息");
        System.out.println(map.getClass());
        System.out.println(map);
    }

    @RabbitListener(queues = {"neusiri.news"})
    public void getMessage2(Message message) throws Exception{
        System.out.println(message.getBody());

        System.out.println("------");
        // 转字符串
        String s = new String(message.getBody());
        System.out.println(s);
        Map map = JSONObject.parseObject(s, Map.class);
        System.out.println(map.getClass());
        System.out.println(map);
        System.out.println(message.getMessageProperties());
    }
}
