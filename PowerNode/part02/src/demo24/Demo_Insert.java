package demo24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author cty
 * @date 2021/9/2 9:28
 */
public class Demo_Insert {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //创建对象
        Connection connection = null;
        Statement statement = null;
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            String url = "jdbc:mysql://localhost:3306/day13?characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
            String user = "root";
            String password = "admin";
            connection = DriverManager.getConnection(url, user, password);
            //获取SQL语句
            statement = connection.createStatement();
            String sql = "insert into person values(null,'小乔',23)";
            //发送SQL语句
            int count = statement.executeUpdate(sql);
            System.out.println("成功插入了" + count + "条数据");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
