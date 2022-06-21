package com.bjpowernode.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author cty
 * @date 2021/9/15 11:56
 */
public class JDBCUtils_bak {
    static String url;
    static String user;
    static String password;
    //当前加载时，实现驱动注册
    static {
        //创建属性及对象
        Properties prop = new Properties();
        try {
            //将文件中的数据读取到属性集中
            InputStream is = JDBCUtils_bak.class.getClassLoader().getResourceAsStream("db.properties");
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String className = prop.getProperty("className");
        url = prop.getProperty("urlName");
        user = prop.getProperty("userName");
        password = prop.getProperty("password");
        try {
            //注册驱动
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //获取连接
    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
    //释放资源
    public static void close(Statement statement, Connection connection) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //释放资源
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(statement, connection);
    }
}
