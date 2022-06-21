package demo23;

import com.mysql.cj.jdbc.Driver;
import java.sql.*;

public class Demo_JDBC {
    public static void main(String[] args) throws SQLException {
        //注册驱动
        DriverManager.registerDriver(new Driver());
        //创建连接
        String url = "jdbc:mysql://localhost:3306/day13?characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "admin";
        Connection connection = DriverManager.getConnection(url, user, password);
        //获取Statement对象
        Statement statement = connection.createStatement();
        // 准备SQL语句
        String sql = "select * from person";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            //获取数据
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String age = resultSet.getString("age");
            System.out.println(id + ".." + name + ".." + age);
        }
        //释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
