package demo24;

import java.sql.*;

public class Demo_MyJDBC {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取连接
        String url = "jdbc:mysql://localhost:3306/day13?characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "admin";
        Connection connection = DriverManager.getConnection(url, user, password);
        //SQL语句对象
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String sql = "select * from person";
        //发送SQL语句
        ResultSet resultSet = statement.executeQuery(sql);
        //遍历结果集
        while (resultSet.next()) {
            //获取数据
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println(id + "..." + name + "..." + age);
        }
        System.out.println("----------分割线----------");
        //回滚结果集
        while (resultSet.previous()) {
            //获取数据
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println(id + "..." + name + "..." + age);
            //修改年龄
            resultSet.updateInt("age", 18);
            resultSet.updateRow();
        }
        //释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
