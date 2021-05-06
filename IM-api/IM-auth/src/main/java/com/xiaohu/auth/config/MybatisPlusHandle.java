package com.xiaohu.auth.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @PackgeName: com.xiaohu.auth.config
 * @ClassName: MybatisPlusHandle
 * @Author: xiaohu
 * Date: 2021/5/6 13:31
 * @Description:
 */
@Component
@Slf4j
public class MybatisPlusHandle implements MetaObjectHandler {
    /**
     * 增加方法的时候自动填充对象
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("执行了");
       this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);

    }

    /**
     * 修改数据的时候自动修改
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("执行了");
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
