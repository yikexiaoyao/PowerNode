package com.bjpowernode.dataservice.mapper;

import com.bjpowernode.exterface.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int getCount();

    Integer getUserCountByPhone(String phone);

    User getUserByPhoneAndPassword();

    User getUserByPhoneAndPassword(String phone, String loginPassword);
}