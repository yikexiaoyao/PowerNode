package demo16;

import java.util.*;
import java.util.stream.Collectors;

public class Demo_GetStreamValueToCollection {
    public static void main(String[] args) {
        //创建集合对象
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3);
        //获取集合中的偶数，保存到新的List集合中
        List<Integer> collect_list = list.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        System.out.println(collect_list);
        //获取集合中的偶数，保存到新的Set集合中
        Set<Integer> collect_set = list.stream().filter(num -> num % 2 != 0).collect(Collectors.toSet());
        System.out.println(collect_set);
    }
}
