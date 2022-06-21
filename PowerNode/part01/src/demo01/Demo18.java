package demo01;

import java.util.Random;
import java.util.Scanner;

public class Demo18 {
    public static void main(String[] args) {
        //猜字游戏
        //随机数出题
        Random random = new Random();
        //取值范围[1，100)
        int anwser = random.nextInt(100) + 1;
        System.out.println("欢迎来到猜字游戏！");
        System.out.println("Are You Ready？Let's Go!");
        System.out.println("----- 退出请输入 0 -----");
        //创建Scanner对象
        Scanner scanner = new Scanner(System.in);
        while(true) {
            int type = scanner.nextInt();
            if (type == 0) {
                System.out.println("太遗憾了，下次再来吧！");
                break;
            } else {
                if (type == anwser) {
                    System.out.println("恭喜你，答对了！");
                    break;
                } else if (type > anwser) {
                    System.out.println("太大了!");
                } else {
                    System.out.println("太小了!");
                }
            }
        }
        //关闭Scanner对象
        scanner.close();
    }
}
