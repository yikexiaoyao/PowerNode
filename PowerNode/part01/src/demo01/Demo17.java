package demo01;

import java.util.Random;
import java.util.Scanner;

public class Demo17 {
    public static void main(String[] args) {
        //加法测试
        System.out.println("欢迎来到加法测试系统！一共十题!");
        System.out.println("Are You Ready？Let's Go!");
        System.out.println("----- 退出请输入 0 -----");
        int i = 1, score = 0, count = 0, answer = 0;
        //创建Scanner对象
        Scanner scanner = new Scanner(System.in);
        while(i<=10){
            //随机数出题
            Random random = new Random();
            //取值范围[1，100)
            int num1 = random.nextInt(100) + 1;
            int num2 = random.nextInt(100) + 1;
            System.out.println("(" + i + ")" + num1 + "+" + num2 + "=" + "?");
            i++;
            answer = num1 + num2;
            int type = scanner.nextInt();
            //判断是否退出
            if (type==0){
                System.out.println("太可惜了，下次再来吧！");
                break;
            }else {
                if (type==answer){
                    System.out.println("正确答案是：" + answer);
                    System.out.println("恭喜你，答对了！加10分！");
                    score+=10;
                    count++;
                }else {
                    System.out.println("正确答案是：" + answer);
                    System.out.println("你真笨！！！这都不会！！！");
                }
            }
        }
        //关闭Scanner对象
        scanner.close();
        System.out.println("测试结束,你一共答对了" + count + "题" + "，共" + score + "分");
    }
}
