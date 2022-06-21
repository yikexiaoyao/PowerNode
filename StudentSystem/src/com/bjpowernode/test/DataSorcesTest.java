package com.bjpowernode.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author cty
 * @date 2021/9/17 21:28
 */
public class DataSorcesTest {
    public static void main(String[] args) throws SQLException {
        //创建核心类对象ComboPooledDataSource
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //创建数据库连接
        Connection conn = dataSource.getConnection();
        //创建statement
        Statement statement = conn.createStatement();
        //执行sql语句
        statement.executeUpdate("delete from student where id = 1");
        //关闭连接
        conn.close();
    }
}
