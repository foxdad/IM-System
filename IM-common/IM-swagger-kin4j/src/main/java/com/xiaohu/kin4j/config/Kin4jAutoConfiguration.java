package com.xiaohu.kin4j.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @PackgeName: com.xiaohu.kin4j.config
 * @ClassName: SwaggerConfig
 * @Author: xiaohu
 * Date: 2021/4/30 12:45
 * @Description:
 */
@Configuration
@EnableSwagger2
@EnableAutoConfiguration
@ConditionalOnProperty(name = "kni4j.enabled", matchIfMissing = true)
public class Kin4jAutoConfiguration {
    /**
     * 默认的排除路径，排除Spring Boot默认的错误处理路径和端点
     */
    private static final List<String> DEFAULT_EXCLUDE_PATH = Arrays.asList("/error", "/actuator/**");

    private static final String BASE_PATH = "/**";


    @Bean
    @ConditionalOnMissingBean
    public Knife4jProperties knife4jProperties()
    {
        return new Knife4jProperties();
    }

    @Bean
    public Docket api(Knife4jProperties kin4jProperties)
    {

        List<Predicate<String>> basePath = new ArrayList<Predicate<String>>();
        kin4jProperties.getBasePath().forEach(path -> basePath.add(PathSelectors.ant(path)));

        // exclude-path处理
        if (kin4jProperties.getExcludePath().isEmpty())
        {
            kin4jProperties.getExcludePath().addAll(DEFAULT_EXCLUDE_PATH);
        }
        List<Predicate<String>> excludePath = new ArrayList<>();
        kin4jProperties.getExcludePath().forEach(path -> excludePath.add(PathSelectors.ant(path)));


        return new Docket(DocumentationType.SWAGGER_2)
                //注释主机信息
//                .host(kin4jProperties.getHost())
                .apiInfo(apiInfo(kin4jProperties)).select()
                .apis(RequestHandlerSelectors.basePackage(kin4jProperties.getBasePackage()))
//                .paths(Predicates.and(Predicates.not(Predicates.or(excludePath)), Predicates.or(basePath)))
                .build().pathMapping("/");
//                .securitySchemes(securitySchemes())
//                .securityContexts(securityContexts())

    }
    private ApiInfo apiInfo(Knife4jProperties kin4jProperties)
    {
        return new ApiInfoBuilder()
                .title(kin4jProperties.getTitle())
                .description(kin4jProperties.getDescription())
                .license(kin4jProperties.getLicense())
                .licenseUrl(kin4jProperties.getLicenseUrl())
//                .termsOfServiceUrl(kin4jProperties.getTermsOfServiceUrl())
                .contact(new Contact(kin4jProperties.getContact().getName(), kin4jProperties.getContact().getUrl(), kin4jProperties.getContact().getEmail()))
                .version(kin4jProperties.getVersion())
                .build();
    }


}
