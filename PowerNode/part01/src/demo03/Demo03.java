package demo03;

import java.util.Scanner;

public class Demo03 {
    //自定义方法之准备
    public static int[] prepare(Scanner scanner) {
        System.out.println("请确认数组的长度");
        //创建数组
        int[] arr = new int[scanner.nextInt()];
        for (int i = 0; i <= arr.length-1 ; i++) {
            System.out.println("请为第" + (i+1) + "个元素赋值");
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
    //自定义方法之打印
    public static void printArray(int[] arr){
        //遍历
        for (int i = 0; i <= arr.length-1 ; i++) {
            if (i == arr.length-1){
                //最后一个
                System.out.println(arr[i]);
            }else {
                //不是最后一个
                System.out.print(arr[i] + ",");
            }
        }
    }
    public static void main(String[] args) {
        //创建Scanner对象
        Scanner scanner = new Scanner(System.in);
        //调用prepare方法
        int[] arr = prepare(scanner);
        //调用printArray方法
        printArray(arr);
        //关闭Scanner对象
        scanner.close();
    }
}
