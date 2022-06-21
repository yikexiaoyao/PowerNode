package demo24;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author cty
 * @date 2021/9/2 11:16
 */
public class Demo_Delete {
    public static void main(String[] args) throws SQLException {
        //创建对象
        Connection connection = null;
        Statement statement = null;
        try {
            //获取连接
            connection = JDBCUtils.getConnection();
            //获取SQL语句对象
            statement = connection.createStatement();
            //发送SQL语句
            int count = statement.executeUpdate("delete from person");
            System.out.println("成功删除了" + count + "条数据");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(statement, connection);
        }
    }
}
