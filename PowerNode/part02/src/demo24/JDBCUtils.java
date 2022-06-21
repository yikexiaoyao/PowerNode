package demo24;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

/**
 * @author cty
 * @date 2021/9/2 10:08
 */
public class JDBCUtils {

    //定义静态变量
    static String url;
    static String user;
    static String password;

    //加载类时注册驱动
    static {
        //创建属性集对象
        Properties prop = new Properties();
        try {
            //讲文件中的数据读取到属性集中
            prop.load(new FileReader("jdbc.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String className = prop.getProperty("className");
        url = prop.getProperty("urlName");
        user = prop.getProperty("userName");
        password = prop.getProperty("passwordName");
        //注册驱动
        try {
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        //获取连接
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
            if (connection != null) {
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
