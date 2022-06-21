package com.bjpowernode.model.service;

import com.bjpowernode.entity.User;

import java.util.List;

/**
 * @author cty
 * @date 2021/10/12 10:34
 */
public interface IUserService extends ITemplateService<User> {
    List<User> search(User user);

    User getByUserName(String userName);

    void delBatch(Object userIds);
}
