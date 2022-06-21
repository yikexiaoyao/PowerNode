package com.bjpowernode.springboot_java.service;

import org.springframework.stereotype.Service;

/**
 * @author cty
 * @date 2021/12/12 20:25
 */
@Service
public class UserServiceImpl implements UserService{

    @Override
    public String sayBye() {
        return "Happy Weekend";
    }
}
