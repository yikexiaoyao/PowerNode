package demo16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class Demo_forEach_filter {
    public static void main(String[] args) {

        //创建集合对象
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        //遍历数据
        Stream<Integer> stream = list.stream();
        stream.forEach(integer -> {
            System.out.println(integer);
        });

        //遍历偶数
        Stream<Integer> stream1 = list.stream();
        Stream<Integer> IntegerStream = stream1.filter(num -> num % 2 == 0);
        IntegerStream.forEach(num -> System.out.println(num));

        list.stream().filter(num -> num % 2 == 0).forEach(num -> System.out.println(num));
    }
}
