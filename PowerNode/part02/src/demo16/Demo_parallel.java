package demo16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Demo_parallel {
    public static void main(String[] args) {
        //创建集合对象
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        //获获取并发流
        list.parallelStream().forEach(num -> System.out.println(num));
        //创建数组
        Integer[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Arrays.stream(integers).parallel().forEach(num -> System.out.println(num));
    }
}
