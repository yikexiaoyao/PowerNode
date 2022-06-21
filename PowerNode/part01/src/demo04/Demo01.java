/*
打印效果：
        11111
        22222
        33333
        44444
        55555
 */
package demo04;

public class Demo01 {
    public static void main(String[] args) {
        //定义二维数组 ==》 5行5列 ==》 5个一维数组（行），每个一维数组都有5个元素（列）
        int[][] arr = new int[5][5];
        //外层循环控制行数，具体到哪一个一维数组
        for (int i = 0; i <= arr.length-1 ; i++) {
            //内层循环控制列数，具体到一维数组中的哪一个元素
            for (int j = 0; j <= arr[i].length-1 ; j++) {
                arr[i][j] = i +1;
            }
        }
        //遍历二维数组
        for (int i = 0; i <= arr.length-1 ; i++) {
            for (int j = 0; j <= arr[i].length-1 ; j++) {
                System.out.print(arr[i][j]);
            }
            //单独换行
            System.out.println();
        }
    }
}
