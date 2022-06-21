package com.bjpowernode.service;

import com.bjpowernode.bean.Permission;
import com.bjpowernode.bean.User;

import java.util.List;

public interface UserService {
    List<Permission> queryMenus(User user);
}
