package demo01;

import java.util.Scanner;

public class Demo03 {
    public static void main(String[] args) {
        System.out.println("购物系统");
        //创建Scanner类的对象
        Scanner scanner = new Scanner(System.in);
        //输入商品单价
        System.out.println("请输入商品单价");
        double price = scanner.nextDouble();
        //输入商品数量
        System.out.println("请输入商品数量");
        int amount = scanner.nextInt();
        //输入付款金额
        System.out.println("请输入付款金额");
        double money = scanner.nextDouble();
        //关闭Scanner对象
        scanner.close();
        double totalPrice = 0,need = 0, change = 0;
        totalPrice = price * amount;
        //支付金额不能小于应付金额
        if (money >= totalPrice){
            //判断是否满足优惠条件
            if (totalPrice>=500){
                System.out.println("您的消费已满500元，可以享受八折优惠");
                need = totalPrice * 0.8;
                System.out.println("应收金额：" + need);
                change = money - need;
                System.out.println("找零：" + change);
            }else {
                System.out.println("应收金额：" + totalPrice);
                change = money - totalPrice;
                System.out.println("找零：" + change);
            }
        }else {
            System.out.println("钱不够");
        }
    }
}
