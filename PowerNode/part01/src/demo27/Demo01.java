package demo27;

import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        System.out.println("请输入用户名和密码");
        //属性
        String name = "admin";
        String password = "123456";
        //创建Scanner对象
        Scanner sc = new Scanner(System.in);
        for (int i = 3; i > 0; i--) {
            System.out.println("请输入用户名");
            String type1 = sc.next();
            if (type1.equals(name)) {
                System.out.println("请输入密码");
                String type2 = sc.next();
                if (type2.equals(password)) {
                    System.out.println("登录成功");
                    break;
                } else {
                    System.out.println("密码错误");
                    System.out.println("还有" + (i - 1) + "次机会");
                }
            } else {
                System.out.println("用户名错误");
                System.out.println("还有" + (i - 1) + "次机会");
            }
        }
        //关闭Scanner对象
        sc.close();
    }
}
