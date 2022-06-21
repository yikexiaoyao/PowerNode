package demo05;

public class Reverse {
    public int[] reverse(int[] arr) {
        //反转数组
        /*
        //方法一
        for (int i = 0; i < arr.length/2 ; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
        */
        //方法二
        for (int i = 0, j = arr.length-1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr [j];
            arr[j] = temp;
        }
        return arr;
    }
    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length-1) {
                System.out.println(arr[i]);
            }else {
                System.out.print(arr[i] + ",");
            }
        }
    }
    public int geMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }
}
