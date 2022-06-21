package com.bjpowernode.dao.impl;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.utils.JDBCUtils_bak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author cty
 * @date 2021/9/15 14:09
 */
public class UserDaoImpl implements UserDao {

    @Override
    public int findCountsByUserAndPwd(Connection conn, String user, String pwd) {
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            //创建sql语句
            String sql = "select count(0) from tb_admin where username = ? and password = ?";
            //创建statement
            statement = conn.prepareStatement(sql);
            //给statement参数赋值
            statement.setString(1, user);
            statement.setString(2, pwd);
            //执行sql语句
            rs = statement.executeQuery();
            //读取返回结果，由于只会返回一行一列，不用循环读取
            rs.next();
            int count = rs.getInt(1);
            return count;
        } catch (SQLException e) {
            return 0;
        } finally {
            //关闭资源
            JDBCUtils_bak.close(rs, statement, conn);
        }
    }

    @Override
    public boolean checkUserName(Connection conn, String user) {
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            //创建sql语句
            String sql = "select count(0) from tb_admin where username = ?";
            //创建statement
            statement = conn.prepareStatement(sql);
            //给sql语句中的参数赋值
            statement.setString(1, user);
            //执行sql语句
            rs = statement.executeQuery();
            //读取返回结果，由于只会返回一行一列，不用循环读取
            rs.next();
            int count = rs.getInt(1);
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return true;
        } finally {
            JDBCUtils_bak.close(rs, statement, conn);
        }
    }

    @Override
    public int insertAdmin(Connection conn, String user, String pwd) {
        PreparedStatement statement = null;
        try {
            //创建sql语句
            String sql = "insert into tb_admin(username,password) values(?,?)";
            //创建statement
            statement = conn.prepareStatement(sql);
            //给sql中的参数赋值
            statement.setString(1, user);
            statement.setString(2, pwd);
            //执行sql语句
            statement.executeUpdate();
            //返回结果
            return 1;
        } catch (SQLException e) {
            return 0;
        } finally {
            JDBCUtils_bak.close(null, statement, null);
        }
    }
}
