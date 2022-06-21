package demo01;

import java.util.Scanner;

public class Demo04 {
    public static void main(String[] args) {
        //创建Scanner类的对象
        Scanner scanner = new Scanner(System.in);
        //输入分值
        System.out.println("考了多少分？（满分100分）");
        double score = scanner.nextDouble();
        //关闭Scanner对象
        scanner.close();
        if (score<0 || score>100){
            System.out.println("你觉得可能吗");
        }else if (score == 100){
            System.out.println("奖励一辆BMW");
        }else if (score>80){
            System.out.println("奖励一台iPhone6s");
        }else if (score>=60){
            System.out.println("奖励一本参考书");
        }else {
            System.out.println("暴打一顿");
        }
    }
}
