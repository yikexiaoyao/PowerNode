package demo24;

class ArrayUtil {

    //求最大值
    public static int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    //求最小值
    public static int min(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    //求和
    public static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    //求平均值
    public static double avg(int[] arr) {
        int avg = 0;
        avg = sum(arr) / arr.length;
        return avg;
    }

    //反转
    public static int[] reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }

    //打印方法
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.println(arr[i]);
            } else {
                System.out.print(arr[i] + ",");
            }
        }
    }

    //遍历
    public static void traverse(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.println(arr[i]);
            } else {
                System.out.print(arr[i] + ",");
            }
        }
    }

    //复制
    public static int[] copy(int[] arr, int[] newArr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                newArr[i] = arr[i];
                System.out.println(arr[i]);
            } else {
                newArr[i] = arr[i];
                System.out.print(arr[i] + ",");
            }
        }
        return newArr;
    }

}

public class Demo07 {
    public static void main(String[] args) {
        int[] arr = {88, 77, 10, 29, 100, 13, 50, 9, 57};
        int[] newArr = new int[10];
        System.out.println(ArrayUtil.max(arr));
        System.out.println("----------分割线----------");
        System.out.println(ArrayUtil.min(arr));
        System.out.println("----------分割线----------");
        System.out.println(ArrayUtil.sum(arr));
        System.out.println("----------分割线----------");
        System.out.println(ArrayUtil.avg(arr));
        /*System.out.println("----------分割线----------");
        System.out.println("反转前");
        ArrayUtil.printArray(arr);
        System.out.println("反转后");
        ArrayUtil.reverse(arr);
        ArrayUtil.printArray(arr);*/
        System.out.println("----------分割线----------");
        ArrayUtil.traverse(arr);
        System.out.println("----------分割线----------");
        ArrayUtil.copy(arr, newArr);
    }
}
