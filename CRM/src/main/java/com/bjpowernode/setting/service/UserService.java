package com.bjpowernode.setting.service;

import com.bjpowernode.setting.bean.User;

/**
 * @author cty
 * @date 2021/10/24 22:22
 */
public interface UserService {
    User login(User user, String code, String correctCode);

    void verifyOldPwd(User user, String oldPwd);

    void updateUser(User user);
}
