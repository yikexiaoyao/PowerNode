package demo05;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Demo07 {
    public static void main(String[] args) {
        System.out.print("请输入一串字母：");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println("str=" + str);
        char[] arr = str.toCharArray();
        //创建LinkedHashSet集合对象
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        //遍历去重
        for (char c : arr) {
            //保存字母
            set.add(c);
        }
        //遍历集合打印
        System.out.print("去重后：");
        for (char ch : set) {
            System.out.print(ch);
        }
    }
}
