package com.xiaohu.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @PackgeName: com.xiaohu.redis.service
 * @ClassName: RedisCache
 * @Author: xiaohu
 * Date: 2021/4/29 18:07
 * @Description:
 */
@Component
public class RedisCache {

    @Autowired
    RedisTemplate<String,Object> redisTemplate;


    /**
     * 添加缓存
     * @param key
     * @param value
     * @param second
     */
    public void set (String key ,Object value,int second) {

        redisTemplate.opsForValue().set(key,value,second);
    }

    /**
     * 获取缓存
     * @param key
     * @return
     */
    public Object get (String key) {

        return redisTemplate.opsForValue().get(key);
    }

}
