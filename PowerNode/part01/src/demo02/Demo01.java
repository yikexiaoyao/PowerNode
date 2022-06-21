package demo02;

import java.util.Scanner;

public class Demo01 {
    //简易计算器
    //自定义方法
    //加法
    public static int jia(int x1, int y1){
        int result1 = x1 + y1;
        return result1;
    }
    //减法
    public static int jian(int x2, int y2){
        int result2 = x2 - y2;
        return result2;
    }
    //乘法
    public static int cheng(int x3, int y3){
        int result3 = x3 * y3;
        return result3;
    }
    //除法
    public static int chu(int x4, int y4){
        int result4 = x4 / y4;
        return result4;
    }
    //除法
    public static int quyu(int x5, int y5){
        int result5 = x5 % y5;
        return result5;
    }

    public static void main(String[] args) {
        int result1, result2, result3, result4, result5;
        //创建Scanner对象
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("欢迎使用简易计算器（加/减/乘/除/取余）");
            System.out.println("请选择操作：（退出请输入 0）");
            System.out.println("1、加法 2、减法 3、乘法 4、除法 5、取余");
            //选择操作
            int type = scanner.nextInt();
            if (type==0){
                System.out.println("感谢您的使用");
                break;
            }else if (type>=1 && type<=5){
                //输入提示
                System.out.println("请分别输入x、y的值，每次输入后按回车键结束");
                //输入x
                int type1 = scanner.nextInt();
                //输入y
                int type2 = scanner.nextInt();
                //分支
                switch (type) {
                    case 1:
                        //调用jia方法
                        result1 = jia(type1, type2);
                        System.out.println(type1 + "+" + type2 + "=" + result1);
                        break;
                    case 2:
                        //调用jian方法
                        result2 = jian(type1, type2);
                        System.out.println(type1 + "-" + type2 + "=" + result2);
                        break;
                    case 3:
                        //调用cheng方法
                        result3 = cheng(type1, type2);
                        System.out.println(type1 + "*" + type2 + "=" + result3);
                        break;
                    case 4:
                        //调用chu方法
                        result4 = chu(type1, type2);
                        System.out.println(type1 + "/" + type2 + "=" + result4);
                        break;
                    case 5:
                        //调用quyu方法
                        result5 = quyu(type1, type2);
                        System.out.println(type1 + "%" + type2 + "=" + result5);
                        break;
                }
            }else {
                System.out.println("操作有误，请重新选择操作！");
            }
        }
        //关闭Scanner对象
        scanner.close();
    }
}
