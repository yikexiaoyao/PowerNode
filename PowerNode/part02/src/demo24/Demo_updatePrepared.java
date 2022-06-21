package demo24;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author cty
 * @date 2021/9/2 15:43
 */
public class Demo_updatePrepared {
    public static void main(String[] args) throws SQLException {
        //创建对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //创建连接
            connection = JDBCUtils.getConnection();
            //准备SQL语句
            String sql = "update person set age = ? where id = ?";
            //获取预编译对象
            preparedStatement = connection.prepareStatement(sql);
            //给?赋值
            preparedStatement.setInt(1, 43);
            preparedStatement.setInt(2, 7);
            //发送SQL语句
            int count = preparedStatement.executeUpdate();
            System.out.println("成功修改了" + count + "条数据");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(preparedStatement, connection);
        }
    }
}
