package com.bjpowernode.springboot_test.controller;

import com.bjpowernode.springboot_test.config.ConfigInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author cty
 * @date 2021/12/10 19:11
 */
@Controller
public class SpringBootController {

    @Value("${school.name}")
    private String schoolName;

    @Value("${school.website}")
    private String schoolWebsite;

    @Autowired
    private ConfigInfo configInfo;

    /**
     * http://localhost:9104/springboot_test/say
     */
    @RequestMapping("/say")
    @ResponseBody
    public String say() {
        return "Hello,springBoot!" + "--->" + schoolName + "--->" + schoolWebsite + "--->" + configInfo;
    }
}
