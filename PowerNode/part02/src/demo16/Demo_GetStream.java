package demo16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo_GetStream {
    public static void main(String[] args) {
        //创建单列集合
        ArrayList<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();
        //创建双列集合
        Map<String, String> map = new HashMap<>();
        Stream<String> stream2 = map.values().stream();
        Stream<String> stream3 = map.values().stream();
        Stream<Map.Entry<String, String>> stream4 = map.entrySet().stream();
        //创建基本类型数据
        int[] intarray = new int[4];
        IntStream stream5 = Arrays.stream(intarray);
        Integer[] integers = new Integer[4];
        Stream<Integer> stream6 = Arrays.stream(integers);
        //通过数据获取Stream流
        Stream<Integer> stream7 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }
}
