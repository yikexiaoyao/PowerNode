package demo24;

import java.util.Random;

public class Demo05 {
    //创建随机数
    public int[] prepare() {
        Random random = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(99) + 1;
        }
        return arr;
    }

    //打印方法
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr.length - 1) {
                System.out.print(arr[i] + "\t");
            } else {
                System.out.println(arr[i]);
            }
        }
    }

    public void main(String[] args) {
        //调用prepare方法
        int[] arr = prepare();
        //调用printArray方法
        printArray(arr);
    }
}
