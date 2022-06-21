package demo27;

import java.util.Scanner;

public class Demo05 {
    public static void main(String[] args) {
        System.out.println("请输入字符串");
        //创建Scanner对象
        Scanner scanner = new Scanner(System.in);
        String type = scanner.next();
        //将字符串转化为字符数组
        char[] arr = type.toCharArray();
        //关闭Scanner对象
        scanner.close();
        boolean isHuiWen = true;
        //遍历判断
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                isHuiWen = false;
            }
        }
        if (isHuiWen) {
            System.out.println("回文字符串");
        } else {
            System.out.println("普通字符串");
        }
    }
}
