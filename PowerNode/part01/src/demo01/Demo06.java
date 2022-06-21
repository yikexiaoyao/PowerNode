package demo01;

import java.util.Scanner;

public class Demo06 {
    public static void main(String[] args) {
        //创建Scanner类的对象
        Scanner scanner = new Scanner(System.in);
        //输入成绩
        System.out.println("请输入成绩");
        double score = scanner.nextDouble();
        //关闭Scanner对象
        scanner.close();
        //判断分值满足的条件
        /*
        if (score>100 || score <0){
            System.out.println("成绩有误");
        }else if (score>=90){
            System.out.println("等级：A");
        }else if (score>=70){
            System.out.println("等级：B");
        }else if (score>=60){
            System.out.println("等级：C");
        }else {
            System.out.println("等级：D");
        }
        */
        if (score<0 || score>100){
            System.out.println("成绩有误");
        }
        switch ((int) (score/10)){
            case 10:
            case 9:
                System.out.println("等级：A");
                break;
            case 8:
            case 7:
                System.out.println("等级：B");
                break;
            case 6:
                System.out.println("等级：C");
                break;
            default:
                System.out.println("等级：D");
                break;
        }
    }
}
