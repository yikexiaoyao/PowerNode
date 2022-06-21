package demo24;

import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        int a = 0, b = 0;
        //创建Scanner对象
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.println("请输入第" + (i + 1) + "个整数");
            int num = scanner.nextInt();
            if (num % 2 == 0) {
                a++;
            } else {
                b++;
            }
        }
        //关闭Scanner对象
        scanner.close();
        //打印
        System.out.println("偶数" + a + "个");
        System.out.println("奇数" + b + "个");
    }
}
