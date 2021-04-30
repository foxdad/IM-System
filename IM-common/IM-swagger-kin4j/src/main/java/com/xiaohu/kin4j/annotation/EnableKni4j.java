package com.xiaohu.kin4j.annotation;

import com.xiaohu.kin4j.config.Kin4jAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @PackgeName: com.xiaohu.kin4j.annotation
 * @ClassName: EnableKni4j
 * @Author: xiaohu
 * Date: 2021/4/30 14:22
 * @Description:
 */

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({ Kin4jAutoConfiguration.class })
public @interface EnableKni4j {

}
