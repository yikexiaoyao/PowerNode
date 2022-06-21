package demo24;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author cty
 * @date 2021/9/2 16:54
 */
public class Demo_Transaction {
    public static void main(String[] args) throws SQLException {
        //创建对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //获取连接
            connection = JDBCUtils.getConnection();
            //开启事物
            connection.setAutoCommit(false);
            //准备SQL语句对象
            String sql = "update account set money = money - 100 where name = ?";
            //获取预编译对象
            preparedStatement = connection.prepareStatement(sql);
            //给?赋值
            preparedStatement.setString(1, "a");
            //执行SQL语句
            preparedStatement.executeUpdate();
            //准备SQL语句
            sql = "update account set money = money + 100 where name = ?";
            preparedStatement = connection.prepareStatement(sql);
            //给?赋值
            preparedStatement.setString(1, "b");
            //执行SQL语句
            preparedStatement.executeUpdate();
            //提交事物
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            //事物回滚
            connection.rollback();
        } finally {
            JDBCUtils.close(preparedStatement, connection);
        }
    }
}
