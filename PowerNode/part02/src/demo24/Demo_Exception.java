package demo24;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author cty
 * @date 2021/9/2 10:05
 */
public class Demo_Exception {
    public static void main(String[] args) throws SQLException {
        //创建对象
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //获取连接
            connection = JDBCUtils.getConnection();
            //SQL语句对象
            statement = connection.createStatement();
            String sql = "select * from person";
            //发送SQL语句
            resultSet = statement.executeQuery(sql);
            //处理结果集
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                System.out.println("name=" + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JDBCUtils.close(resultSet, statement, connection);
        }
    }
}
