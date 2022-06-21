package com.bjpowernode.test;

import com.bjpowernode.utils.JDBCUtils_bak;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author cty
 * @date 2021/9/15 11:55
 */
public class JDBCTest {
    public static void main(String[] args) throws SQLException {
        //获取数据库连接
        Connection connection = JDBCUtils_bak.getConnection();
        System.out.println(connection);
    }
}
