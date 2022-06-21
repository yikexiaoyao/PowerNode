package demo24;

import java.util.Arrays;

public class Demo06 {
    public static void main(String[] args) {
        //创建数组
        int[] arr = {1, 2, 3, 4, 3, 2, 1};
        boolean isDuiCheng = true;
        //遍历判断
        for (int i = 0; i < arr.length/2; i++) {
            if (arr[i] != arr[arr.length - 1- i]) {
                isDuiCheng = false;
            }
        }
        if (isDuiCheng) {
            System.out.println(Arrays.toString(arr) + "是否对称：" + isDuiCheng);
        } else {
            System.out.println(Arrays.toString(arr) + "是否对称：" + isDuiCheng);
        }
    }
}