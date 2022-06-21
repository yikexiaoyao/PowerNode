package demo16;

import java.io.Serializable;
import java.util.stream.Stream;

public class Demo_concat {
    public static void main(String[] args) {
        //创建流对象
        Stream<String> a = Stream.of("a", "b", "c");
        Stream<String> b = Stream.of("A", "B", "C");
        Stream<Integer> c = Stream.of(1, 2, 3);
        //合并流
        Stream<? extends Serializable> concatStream = Stream.concat(a, c);
        concatStream.forEach(ser -> System.out.println(ser));
    }
}
