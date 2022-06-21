package demo01;

import java.util.Scanner;

public class Demo12 {
    public static void main(String[] args) {
        //创建Scanner类的对象
        Scanner scanner = new Scanner(System.in);
        //输入姓名
        System.out.println("请输入姓名：");
        String name = scanner.next();
        //关闭Scanner对象
        scanner.close();
        System.out.println("您的姓名是" + name);
    }
}
