package com.bjpowernode.springboot_test.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author cty
 * @date 2021/12/10 19:21
 */
@ConfigurationProperties(prefix = "school")
@Component
public class ConfigInfo {
    private String name;
    private String website;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "ConfigInfo{" +
                "name='" + name + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
