package demo04;

import java.util.Arrays;
import java.util.Comparator;

public class Demo06 {
    public static void main(String[] args) {

        //创建数组
        Integer[] arr = {2, 9, 5, 1, 6, 7, 3, 8, 4};
        System.out.println(Arrays.toString(arr));

        //升序
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        //降序
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(arr));

        //部分排序
        Arrays.sort(arr, 2, 6, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(Arrays.toString(arr));

    }
}
