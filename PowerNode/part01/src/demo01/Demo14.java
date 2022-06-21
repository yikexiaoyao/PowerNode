package demo01;

import java.util.Scanner;

public class Demo14 {
    public static void main(String[] args) {
        int a = 0, b = 0, c = 0;
        //创建Scanner类的对象
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 10 ; i++) {
            System.out.println("请输入一个整数");
            int num = scanner.nextInt();
            if (num != 0){
                if (num > 0){
                    a++;
                }else{
                    b++;
                }
            }else {
                c++;
            }
        }
        //关闭Scanner对象
        scanner.close();
        //输出
        System.out.println("正数" + a + "个");
        System.out.println("负数" + b + "个");
        System.out.println("零" + c + "个");
    }
}
