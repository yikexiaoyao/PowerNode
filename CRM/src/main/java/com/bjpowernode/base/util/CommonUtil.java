package com.bjpowernode.base.util;

import com.bjpowernode.setting.bean.User;
import com.bjpowernode.setting.mapper.UserMapper;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.List;

public class CommonUtil {

    //获取当前登录用户
    public static User getCurrentUser(HttpSession session) {
        return (User) session.getAttribute("user");
    }

    //返回设置好所有者的数据
    public static <T> void convertOwner(List<T> data, Class<T> clazz, UserMapper userMapper) {
        Method[] methods = clazz.getDeclaredMethods();
        for (T t : data) {
            String name = "";
            for (Method method : methods) {
                //获取方法的名字
                String methodName = method.getName();
                if ("getOwner".equals(methodName)) {
                    try {
                        String owner = (String) method.invoke(t);
                        User user = userMapper.selectByPrimaryKey(owner);
                        name = user.getName();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if ("setOwner".equals(methodName)) {
                    try {
                        if (name != null && name != "") {
                            method.invoke(t, name);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
