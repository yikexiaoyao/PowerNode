package com.bjpowernode.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author cty
 * @date 2021/9/17 21:13
 */
public class JDBCUtils {
    private final static ComboPooledDataSource dataSource = new ComboPooledDataSource();
    //获取连接
    public static Connection getConnection() throws SQLException {
        //获取连接
        return dataSource.getConnection();
    }
    // 释放资源
    public static void close(Statement statement , Connection connection ) {
        try {
            if( statement != null ) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if( connection != null ) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 释放资源
    public static void close(ResultSet resultSet, Statement statement , Connection connection ) {
        try {
            if( resultSet != null ) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(statement, connection);
    }
}
