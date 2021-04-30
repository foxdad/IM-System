package com.xiaohu.kin4j.config;

import io.swagger.models.Contact;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackgeName: com.xiaohu.kin4j.config
 * @ClassName: SwaggerPrperties
 * @Author: xiaohu
 * Date: 2021/4/30 12:45
 * @Description:
 */

@Component
@ConfigurationProperties("kni4j")
public class Knife4jProperties {

    private String title = "";

    private String description = "";

    private String version = "";

    private Contact contact = new Contact();

    private String license = "";

    private String licenseUrl = "";

    /**
     * swagger会解析的url规则
     **/
    private List<String> basePath = new ArrayList<>();

    /**
     * swagger会解析的包路径
     **/
    private String basePackage = "";

    /**
     * 在basePath基础上需要排除的url规则
     **/
    private List<String> excludePath = new ArrayList<>();

    public static class Contact
    {
        /**
         * 联系人
         **/
        private String name = "";
        /**
         * 联系人url
         **/
        private String url = "";
        /**
         * 联系人email
         **/
        private String email = "";

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public String getUrl()
        {
            return url;
        }

        public void setUrl(String url)
        {
            this.url = url;
        }

        public String getEmail()
        {
            return email;
        }

        public void setEmail(String email)
        {
            this.email = email;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getLicenseUrl() {
        return licenseUrl;
    }

    public void setLicenseUrl(String licenseUrl) {
        this.licenseUrl = licenseUrl;
    }

    public List<String> getBasePath() {
        return basePath;
    }

    public void setBasePath(List<String> basePath) {
        this.basePath = basePath;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public List<String> getExcludePath() {
        return excludePath;
    }

    public void setExcludePath(List<String> excludePath) {
        this.excludePath = excludePath;
    }
}
