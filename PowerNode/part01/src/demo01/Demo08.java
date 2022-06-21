package demo01;

import java.util.Scanner;

public class Demo08 {
    public static void main(String[] args) {
        //创建Scanner类的对象
        Scanner scanner = new Scanner(System.in);
        //输入年份
        System.out.println("请输入年份");
        int year = scanner.nextInt();
        //请输入月份
        System.out.println("请输入月份");
        int month = scanner.nextInt();
        //关闭Scanner对象
        scanner.close();
        //判断是否为闰年
        if ((year%4==0 && year%100!=0) || (year%400 == 0)){
            if (month==2){
                System.out.println("29天");
            }
        }else {
            if (month==2){
                System.out.println("28天");
            }
        }
        //其他月份
        switch (month){
            /*
            case 1:
                System.out.println("31天");
                break;
            case 3:
                System.out.println("31天");
                break;
            case 4:
                System.out.println("30天");
                break;
            case 5:
                System.out.println("31天");
                break;
            case 6:
                System.out.println("30天");
                break;
            case 7:
                System.out.println("31天");
                break;
            case 8:
                System.out.println("31天");
                break;
            case 9:
                System.out.println("30天");
                break;
            case 10:
                System.out.println("31天");
                break;
            case 11:
                System.out.println("30天");
                break;
            case 12:
                System.out.println("31天");
                break;
            */
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("31天");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("30天");
                break;
        }
    }
}
