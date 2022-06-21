package com.bjpowernode.springboot_dubbo_consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bjpowernode.springboot_dubbo_exterface.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author cty
 * @date 2021/12/12 19:08
 */
@RestController
public class UserController {
    @Reference(interfaceClass = UserService.class, version = "1.2.3", timeout = 20000, retries = 3)
    UserService userService;

    @RequestMapping("/hello")
    public Object hello(HttpServletRequest request) {
        String sayHello = userService.say("SpringBoot");
        return sayHello;
    }
}
