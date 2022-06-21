package com.bjpowernode.service.impl;

import com.bjpowernode.User;
import com.bjpowernode.UserService;

/**
 * @author cty
 * @date 2021/12/6 10:08
 */
public class UserServiceImpl implements UserService {
    @Override
    public User getInfo() {
        User user = new User();
        user.setUsername("张三");
        user.setAddress("上海动力节点");

        return user;
    }
}
