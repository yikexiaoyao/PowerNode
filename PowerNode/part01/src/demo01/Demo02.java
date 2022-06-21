package demo01;

import java.util.Scanner;

public class Demo02 {
    public static void main(String[] args) {
        System.out.println("嫁吗？");
        //创建Scanner类的对象
        Scanner scanner = new Scanner(System.in);
        //输入身高
        System.out.println("身高：（cm）");
        int height = scanner.nextInt();
        //输入财富
        System.out.println("财富：（千万）");
        double money = scanner.nextDouble();
        //帅否
        System.out.println("帅否：（true/false）");
        boolean handsome = scanner.nextBoolean();
        //关闭Scanner对象
        scanner.close();
        //是否满足条件
        if (height>180 && money>1 && handsome==true){
            System.out.println("我一定要嫁给他！！！");
        }else if (height>180 || money>1 || handsome){
            System.out.println("嫁吧，比上不足，比下有余。");
        }else{
            System.out.println("不嫁！");
        }
    }
}
