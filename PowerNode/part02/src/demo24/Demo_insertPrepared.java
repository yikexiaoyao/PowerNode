package demo24;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author cty
 * @date 2021/9/2 15:27
 */
public class Demo_insertPrepared {
    public static void main(String[] args) throws SQLException {
        //创建对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //获取连接
            connection = JDBCUtils.getConnection();
            //准备SQL语句对象
            String sql = "insert into person values(null,?,?)";
            //获取预编译对象
            preparedStatement = connection.prepareStatement(sql);
            //给?赋值
            preparedStatement.setString(1, "周瑜");
            preparedStatement.setInt(2, 42);
            //发送SQL语句
            int count = preparedStatement.executeUpdate();
            System.out.println("成功插入了" + count + "条数据");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(preparedStatement, connection);
        }
    }
}
