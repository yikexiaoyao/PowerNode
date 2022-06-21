package com.bjpowernode.service.impl;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.dao.impl.UserDaoImpl;
import com.bjpowernode.service.UserService;
import com.bjpowernode.utils.JDBCUtils_bak;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author cty
 * @date 2021/9/15 14:08
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean checkUserAndPwd(String user, String pwd) {
        Connection conn = null;
        try {
            //获取数据库连接
            conn = JDBCUtils_bak.getConnection();
            //根据账号密码检测是否匹配
            int count = userDao.findCountsByUserAndPwd(conn, user, pwd);
            //根据count返回true或false
            if (count > 0) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            return false;
        } finally {
            //关闭资源
            JDBCUtils_bak.close(null, null, conn);
        }
    }

    @Override
    public int register(String user, String pwd) {
        Connection conn = null;
        //定义返回结果
        int result = 1;
        try {
            //获取数据库连接
            conn = JDBCUtils_bak.getConnection();
            //根据账号检测是否重复
            boolean flag = userDao.checkUserName(conn, user);
            if (flag) {
                //true表示重复
                return -1;
            } else {
                //false表示不重复
                result = userDao.insertAdmin(conn, user, pwd);
            }
            return result;
        } catch (SQLException e) {
            //注册失败，返回0
            return 0;
        } finally {
            //关闭资源
            JDBCUtils_bak.close(null, null, conn);
        }
    }
}
