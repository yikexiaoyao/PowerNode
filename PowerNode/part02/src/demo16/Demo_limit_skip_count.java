package demo16;

import java.util.Arrays;
import java.util.stream.Stream;

public class Demo_limit_skip_count {
    public static void main(String[] args) {
        //创建数组
        Integer[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //获取Stream流对象
        Stream<Integer> stream = Arrays.stream(integers);

        long count = stream.limit(7).skip(3).filter(num -> num % 2 == 0).count();
        System.out.println("count=" + count);
    }
}
