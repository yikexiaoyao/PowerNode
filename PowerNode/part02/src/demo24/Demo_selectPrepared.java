package demo24;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author cty
 * @date 2021/9/2 15:20
 */
public class Demo_selectPrepared {
    public static void main(String[] args) throws SQLException {
        //创建对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //获取链接
            connection = JDBCUtils.getConnection();
            //准备SQL语句对象
            String sql = "select * from person where name like ?";
            //获取预编译对象
            preparedStatement = connection.prepareStatement(sql);
            //给?赋值
            preparedStatement.setString(1, "张%");
            //发送SQL语句
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //获取数据
                String name = resultSet.getString("name");
                System.out.println("name=" + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }
    }
}
