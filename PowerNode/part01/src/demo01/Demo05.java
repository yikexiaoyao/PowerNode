package demo01;

import java.util.Scanner;

public class Demo05 {
    public static void main(String[] args) {
        //创建Scanner类的对象
        Scanner scanner = new Scanner(System.in);
        //输入月份
        System.out.println("请输入月份");
        int month = scanner.nextInt();
        //关闭Scanner对象
        scanner.close();
        //锁定范围
        if (month<1 || month>12){
            System.out.println("月份有误");
        }
        //分支
        switch (month){
            case 3:
                /*
                System.out.println("春季");
                break;*/
            case 4:
                /*
                System.out.println("春季");
                break;
                 */
            case 5:
                System.out.println("春季");
                break;
            case 6:
                /*
                System.out.println("夏季");
                break;
                 */
            case 7:
                /*
                System.out.println("夏季");
                break;
                 */
            case 8:
                System.out.println("夏季");
                break;
            case 9:
                /*
                System.out.println("秋季");
                break;
                 */
            case 10:
                /*
                System.out.println("秋季");
                break;
                 */
            case 11:
                System.out.println("秋季");
                break;
            default:
                System.out.println("冬季");
                break;
        }
    }
}
