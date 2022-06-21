package com.bjpowernode.model.service;

import com.bjpowernode.entity.User;
import com.bjpowernode.model.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cty
 * @date 2021/10/12 10:35
 */
@Service
public class UserService implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> list() {
        return userMapper.selectAll();
    }

    @Override
    public User get(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delete(int id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(User obj) {
        userMapper.updateByPrimaryKeySelective(obj);
    }

    @Override
    public void save(User obj) {
        userMapper.insertSelective(obj);
    }

    @Override
    public List<User> search(User user) {
        return userMapper.search(user);
    }

    @Override
    public User getByUserName(String userName) {
        return userMapper.selectByUserName(userName);
    }

    @Override
    public void delBatch(Object userIds) {
        userMapper.delBatch(userIds);
    }

}
