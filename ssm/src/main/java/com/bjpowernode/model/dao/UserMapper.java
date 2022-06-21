package com.bjpowernode.model.dao;

import com.bjpowernode.entity.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();

    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> search(User user);

    User selectByUserName(String userName);

    void delBatch(Object userIds);
}