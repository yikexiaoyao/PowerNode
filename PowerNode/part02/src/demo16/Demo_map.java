package demo16;

import java.util.stream.Stream;

public class Demo_map {
    public static void main(String[] args) {
        //获取Stream流对象
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        stream.map(num -> String.valueOf(num)).forEach(str -> System.out.println(str));
    }
}
