package demo27;

import java.util.Arrays;
import java.util.Scanner;

public class Demo06 {
    //自定义方法
    public static char[] prepare(char[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println("请输入字符串");
        //创建Scanner对象
        Scanner scanner = new Scanner(System.in);
        String type = scanner.next();
        //将字符串转化为字符数组
        char[] arr = type.toCharArray();
        //关闭Scanner对象
        scanner.close();
        String result = Arrays.toString(arr).equals(Arrays.toString(prepare(arr))) ? "是回文" : "不是回文";
        System.out.println(result);
    }
}
