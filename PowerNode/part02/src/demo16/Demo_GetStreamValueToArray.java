package demo16;

import java.util.Arrays;
import java.util.function.IntFunction;
import java.util.stream.Stream;

public class Demo_GetStreamValueToArray {
    public static void main(String[] args) {
        //获取Stream 收集到Object数组中
        Object[] objects = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).toArray();
        System.out.println(Arrays.toString(objects ));

        //获取Stream，收集到指定数组中
        Integer[] integers = Stream.of(1, 2, 3).toArray(new IntFunction<Integer[]>() {
            @Override
            public Integer[] apply(int value) {
                return new Integer[value];
            }
        });
        System.out.println(Arrays.toString(integers));
        System.out.println("----------分割线----------");
        Integer[] integers1 = Stream.of(1, 2, 3).toArray(value -> new Integer[value]);
        System.out.println(Arrays.toString(integers1));
    }
}
