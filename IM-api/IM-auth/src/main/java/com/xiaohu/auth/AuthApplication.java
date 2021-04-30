package com.xiaohu.auth;

import com.xiaohu.kin4j.annotation.EnableKni4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @PackgeName: com.xiaohu.auth
 * @ClassName: AuthApplication
 * @Author: xiaohu
 * Date: 2021/4/30 11:23
 * @Description:
 */

@MapperScan(basePackages = "com.xiaohu.auth.mapper")
@EnableKni4j
@SpringBootApplication
public class AuthApplication {
    public static void main(String[] args) {

        SpringApplication.run(AuthApplication.class,args);

    }
}
