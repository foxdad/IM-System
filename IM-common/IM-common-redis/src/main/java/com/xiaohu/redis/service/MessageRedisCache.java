package com.xiaohu.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @PackgeName: com.xiaohu.redis.service
 * @ClassName: MessageRedisCache
 * @Author: xiaohu
 * Date: 2021/5/6 14:48
 * @Description:
 */
@Component
public class MessageRedisCache {

    @Autowired
    RedisTemplate<String,String> redisTemplate;


    /**
     * 添加缓存
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key ,String value) {
        try{
            redisTemplate.opsForValue().set(key,value);
        }catch (Exception e ){
            return false;
        }
        return true;
    }

    /**
     * 获取缓存
     * @param key
     * @return
     */
    public String get (String key) {

        return redisTemplate.opsForValue().get(key);
    }


    public List<String> getList (String key){

        List<String> range = redisTemplate.opsForList().range(key, 0, -1);
        return range;
    }

    public void setList (String key , String value) {
        redisTemplate.opsForList().leftPush(key, value);
    }
}
