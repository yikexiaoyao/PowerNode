package com.bjpowernode.mapper;

import com.bjpowernode.bean.Permission;
import com.bjpowernode.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User verifyPrincipal(@Param("username") String principal);

    List<Permission> queryMenus(User user);

    List<Permission> queryPermissions(User user);
}
