package demo24;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author cty
 * @date 2021/9/2 11:52
 */
public class Demo_Login {
    public static void main(String[] args) throws SQLException {
        //创建键盘输入对象
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String username = scanner.next();
        System.out.print("请输入密码：");
        String password = scanner.next();
        boolean result = login(username, password);
        System.out.println(result ? "登陆成功" : "登录失败");
    }

    //验证登录
    private static boolean login(String username, String password) throws SQLException {
        //创建对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //获取连接
            connection = JDBCUtils.getConnection();
            //准备SQL语句框架
            String sql = "select * from user where username = ? && password = ?";
            //获取预编译对象
            preparedStatement = connection.prepareStatement(sql);
            //给?赋值
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            //发送SQL语句
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }
        return false;
    }
}
