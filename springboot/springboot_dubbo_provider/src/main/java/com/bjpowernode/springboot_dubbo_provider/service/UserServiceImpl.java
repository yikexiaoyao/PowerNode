package com.bjpowernode.springboot_dubbo_provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.bjpowernode.springboot_dubbo_exterface.service.UserService;
import org.springframework.stereotype.Component;

/**
 * @author cty
 * @date 2021/12/12 18:28
 */
@Service(interfaceClass = UserService.class,version = "1.2.3",timeout = 20000,retries =3)
@Component
public class UserServiceImpl implements UserService {
    @Override
    public String say(String name) {
        return "Hello SpringBoot!";
    }
}
