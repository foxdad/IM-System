package com.xiaohu.message;

import com.xiaohu.kin4j.annotation.EnableKni4j;
import com.xiaohu.redis.service.RedisCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @PackgeName: com.xiaohu.message
 * @ClassName: MessageApplication
 * @Author: xiaohu
 * Date: 2021/4/30 11:23
 * @Description:
 */
@EnableKni4j
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, RedisCache.class})
public class MessageApplication {
    public static void main(String[] args) {

        SpringApplication.run(MessageApplication.class,args);

    }
}
