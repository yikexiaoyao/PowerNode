package com.bjpowernode.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author cty
 * @date 2021/9/15 14:09
 */
public interface UserDao {
    //根据账号密码查询记录的数量
    int findCountsByUserAndPwd(Connection conn, String user, String pwd);
    //检查账号是否重复
    boolean checkUserName(Connection conn, String user);
    //添加账号
    int insertAdmin(Connection conn, String user, String pwd);
}
