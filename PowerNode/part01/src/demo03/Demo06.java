package demo03;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Demo06 {
    public static int[] prepare() {
        System.out.println("请输入随机数组长度");
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[scanner.nextInt()];
        Random random = new Random();
        for (int i = 0; i <= arr.length-1 ; i++) {
            arr[i] = random.nextInt(100) + 1;
        }
        return arr;
    }
    /*
    //选择排序升序
    public static void select(int[] arr){
        //外层循环控制轮数
        for (int i = 0; i <= arr.length - 2; i++) {
            //内层循环控制每一轮的执行次数
            for (int j = i+1; j <= arr.length - 1; j++) {
                int temp = arr[i];
                if (arr[i] > arr[j]) {
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    //遍历
    public static void printArray(int[] arr){
        for (int i = 0; i <= arr.length - 2; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
     */
    public static void main(String[] args) {
        int[] arr = prepare();
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        //printArray(arr);
        Arrays.sort(arr);
        //select(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
        //printArray(arr);
    }
}
