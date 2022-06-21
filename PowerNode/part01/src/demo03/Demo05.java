package demo03;

import java.util.Scanner;

public class Demo05 {
    public static void main(String[] args) {
        int[] arr = new int[26];
        for (int i = 0; i <=25 ; i++) {
            arr[i] = 65 + i;
            System.out.println((char)(arr[i]+32) + "->" + (char)(arr[i]));
        }

        System.out.println("----------分割线----------");

        System.out.println("英文字母大小写转换");
        System.out.println("请输入字母");
        Scanner scanner = new Scanner(System.in);
        char num = scanner.next().charAt(0);
        if(num >= 'a' && num <= 'z'){
            //小转大 ==》 ASCII码-32
            System.out.println(num);
            System.out.println(num + "->" + (char)(num - 32));
        }else if (num >= 'A' && num <= 'Z'){
            //大转小 ==》 ASCII码+32
            System.out.println(num);
            System.out.println(num + "->" + (char)(num + 32));
        }else {
            System.out.println("字母有误，请重新输入！");
        }
    }
}
