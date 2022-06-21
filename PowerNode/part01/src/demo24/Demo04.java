package demo24;

import java.util.Random;
import java.util.Scanner;

public class Demo04 {
    //准备
    public static int[] prepare() {
        System.out.println("请输入数组的长度");
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[scanner.nextInt()];
        scanner.close();
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(99) + 1;
        }
        return arr;
    }

    //打印数组
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                System.out.print(arr[i] + ", ");
            } else {
                System.out.println(arr[i]);
            }
        }
    }

    //统计分数
    public static void count(int[] arr) {
        double avg = 0, score = 0;
        int j = 0, high = 0;
        for (int i = 0; i < arr.length; i++) {
            score += arr[i];
            j++;

        }
        for (int i = 0; i < arr.length; i++) {
            avg = score / j;
            if (arr[i] > avg) {
                high++;
            }
        }
        System.out.println("总分" + score);
        System.out.println("平均分" + avg);
        System.out.println("高于平均分人数" + high);
    }

    public static void main(String[] args) {
        int[] arr = prepare();
        printArray(arr);
        count(arr);
    }
}
