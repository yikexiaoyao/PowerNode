package demo24;

public class Demo02 {
    //自定义方法
    public static void getArray(int[] arr) {
        //获取新数组长度
        int size = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] >= 50) && (arr[i] % 2 == 0)) {
                size++;
            }
        }
        //System.out.println(size);
        //创建新数组
        int[] arr1 = new int[size];
        int a = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] >= 50) && (arr[i] % 2 == 0)) {
                arr1[a] = arr[i];
                a++;
            }
        }
        //遍历打印
        for (int j = 0; j < arr1.length; j++) {
            if (j != arr1.length - 1) {
                System.out.print(arr1[j] + ", ");
            } else {
                System.out.println(arr1[j]);
            }
        }
    }

    public static void main(String[] args) {
        //创建静态数组
        int[] arr = {88, 77, 10, 29, 100, 13, 50, 9, 57};
        //调用自定义方法
        getArray(arr);
    }
}
