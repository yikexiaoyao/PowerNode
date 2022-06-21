package com.bjpowernode.service.impl;

import com.bjpowernode.bean.Permission;
import com.bjpowernode.bean.User;
import com.bjpowernode.mapper.UserMapper;
import com.bjpowernode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    //迭代器循环不能边迭代边删除，只能用普通循环
    @Override
    public List<Permission> queryMenus(User user) {
        List<Permission> menus = userMapper.queryMenus(user);
        for (int i = menus.size() - 1 ; i >= 0 ; i--) {
            Permission menu = menus.get(i);
            List<Permission> sons = new ArrayList<>();
            for (int j = menus.size() -1; j >= 0; j--) {
                Permission permission = menus.get(j);
                if(menu == permission){
                    continue;
                }
                if(permission.getParent_id() != null && permission.getParent_id().equals(menu.getPid())){
                    sons.add(permission);
                   menus.remove(permission);
                }
            }
            //把子菜单设置到对应menu中
            menu.setSons(sons);
        }
        return menus;
    }
}
