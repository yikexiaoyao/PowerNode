package demo03;

import java.util.Scanner;

public class Demo02 {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 9};
        for (int i = 0; i <= arr1.length-1 ; i++) {
            System.out.println(arr1[i]);
        }

        System.out.println("----------分割线----------");

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        for (int j = 0; j <= arr2.length-1 ; j++) {
            System.out.println(arr2[j] + "月份");
        }

        System.out.println("----------分割线----------");

        String[] arr3 = new String[7];
        arr3[0] = "Monday";
        arr3[1] = "Tuesday";
        arr3[2] = "Wednesday";
        arr3[3] = "Thursday";
        arr3[4] = "Friday";
        arr3[5] = "Saturday";
        arr3[6] = "Sunday";
        System.out.println("请输入数字");
        Scanner scanner = new Scanner(System.in);
        int day = scanner.nextInt();
        if (day>=1 && day<=7){
            System.out.println(arr3[day-1]);
        }else {
            System.out.println("输入错误，请重新输入");
        }
        scanner.close();
    }
}
