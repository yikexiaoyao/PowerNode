package demo23;

import java.sql.*;
import java.util.ArrayList;

public class Demo_API {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/day13?characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "admin";
        Connection connection = DriverManager.getConnection(url, user, password);
        //获取Statement对象
        Statement statement = connection.createStatement();
        //准备SQL语句
        //String sql = "update person set age = 20";
        String sql = "select * from person";
        //创建集合保存对象
        ArrayList<Person> list = new ArrayList<>();
        boolean result = statement.execute(sql);
        if (result) {
            //查询语句，处理结果集
            ResultSet resultSet = statement.getResultSet();
            //判断是否有数据
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                //封装成员Person对象
                Person person = new Person(id, name, age);
                list.add(person);
            }
        } else {
            //更新语句,处理更新条数
            int count = statement.getUpdateCount();
            System.out.println("更新成功，更新了" + count + "条数据");
        }
        //遍历集合
        for (Person person : list) {
            System.out.println(person);
        }
        // 释放资源
        statement.close();
        connection.close();
    }
}
