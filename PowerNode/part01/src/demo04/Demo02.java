/*
    打印效果：
            1
            22
            333
            4444
            55555
 */
package demo04;

public class Demo02 {
    public static void main(String[] args) {
        //定义二维数组，有5个一维数组
        int[][] arr = new int[5][];
        //为每个一维数组确定大小（元素个数）
        for (int i = 0; i <= arr.length-1; i++) {
            arr[i] = new int[i+1];
        }
        //为每一个一维数组中的元素赋值
        for (int i = 0; i <=arr.length-1; i++) {
            for (int j = 0; j <= arr[i].length-1; j++) {
                arr[i][j] = i + 1;
            }
        }
        //遍历二维数组
        for (int i = 0; i <=arr.length-1; i++) {
            for (int j = 0; j <=arr[i].length-1; j++) {
                System.out.println(arr[i][j]);
            }
            System.out.println();
        }
    }
}
