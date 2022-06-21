package demo24;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

/**
 * @author cty
 * @date 2021/9/2 17:23
 */
public class Demo_savePoint {
    public static void main(String[] args) throws SQLException {
        //创建对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Savepoint savepoint = null;
        try {
            //获取连接
            connection = JDBCUtils.getConnection();
            //开启事物
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint();
            //准备SQL语句
            String sql = "insert into person values(null,?,?)";
            //获取预编译数据
            preparedStatement = connection.prepareStatement(sql);
            //循环给?赋值
            for (int i = 1; i <= 10000; i++) {
                preparedStatement.setString(1, "张三");
                preparedStatement.setInt(2, 20);
                //发送SQL语句
                preparedStatement.executeUpdate();
                //执行到此处发生异常
                if (i == 9527) {
                    int num = 1 / 0;
                }
                //设置回滚点
                if (i % 500 == 0) {
                    savepoint = connection.setSavepoint();
                }
            }
            //提交事物
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //事物回滚到回滚点的位置
            connection.rollback(savepoint);
            //提交发生异常之前的数据
            connection.commit();
        } finally {
            JDBCUtils.close(preparedStatement, connection);
        }
    }
}
