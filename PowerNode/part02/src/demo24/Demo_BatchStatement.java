package demo24;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author cty
 * @date 2021/9/2 16:05
 */
public class Demo_BatchStatement {
    public static void main(String[] args) throws SQLException {
        //创建对象
        Connection connection = null;
        Statement statement = null;
        try {
            //获取连接
            connection = JDBCUtils.getConnection();
            //获取Statement对象
            statement = connection.createStatement();
            //插入10000条数据
            for (int i = 1; i <= 10020; i++) {
                String sql = "insert into person values(null,'name',20)";
                //添加批处理到列表中
                statement.addBatch(sql);
                //判断是否够1000条
                if (i % 1000 == 0) {
                    statement.executeBatch();
                    //清空批处理列表
                    statement.clearBatch();
                }
            }
            //执行批处理
            statement.executeBatch();
            //清空批处理列表
            statement.clearBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(statement, connection);
        }
    }
}
