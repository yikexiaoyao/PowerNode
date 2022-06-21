package demo16;

import java.util.Random;
import java.util.stream.Stream;

public class Demo_method {

    // 判断流中的数据是否有满足条件的存在【有一个即可】
    private static void anyMatch() {
        boolean result = Stream.of(1, 2, 4, 6).anyMatch(num -> num % 2 == 0);
        System.out.println("result = " + result);
    }

    // 判断流中的所有数据是否和条件不一致
    private static void noneMatch() {
        boolean result = Stream.of(1, 3, 5).noneMatch(num -> num % 2 == 0);
        System.out.println("result = " + result);
    }

    // 判断流中的所有数据是否和条件一致
    private static void allMatch() {
        boolean result = Stream.of(2, 4, 6).allMatch(num -> num % 2 == 0);
        System.out.println("result = " + result);
    }

    // 删除 通过条件删除流中的数据，满足条件的数据保存，直到遇到第一个不满足条件的数据开始，删除后续的所有数据
    private static void takeWhile() {
        Stream.of(2, 4, 6, 8, 1, 2, 3, 4, 5, 6, 7, 8, 9).takeWhile(num -> num % 2 == 0).forEach(num -> System.out.println(num));
    }

    // 删除 通过条件删除流中的数据，直到遇到第一个不满足条件的数据开始，保存后续的所有数据
    private static void dropWhile() {
        Stream.of(2, 4, 6, 8, 1, 2, 3, 4, 5, 6, 7, 8, 9).dropWhile(num -> num % 2 == 0).forEach(num -> System.out.println(num));
    }

    // 无限随机流
    private static void generate​() {
        Stream.generate(() -> new Random().nextInt(100)).limit(10).forEach(num -> System.out.println(num));
    }

    // 获取最值
    private static void max_min() {
        // 最大值
        Integer max = Stream.of(1, 3, 4, 6, 9).max((o1, o2) -> o1 - o2).get();
        System.out.println("max = " + max);
        // 最小值
        Integer min = Stream.of(1, 3, 4, 6, 9).min((o1, o2) -> o1 - o2).get();
        System.out.println("min = " + min);
    }

    // 排序
    private static void sorted() {
        // 升序
        Stream.of(2, 1, 4, 3, 6, 8, 7, 9).sorted().forEach(num -> System.out.println(num));
        // 降序
        Stream.of(2, 1, 4, 3, 6, 8, 7, 9).sorted((o1, o2) -> o2 - o1).forEach(num -> System.out.println(num));
    }

    // 排重
    private static void distinct() {
        Stream.of(1, 2, 3, 1, 2, 3).distinct().forEach(num -> System.out.println(num));
    }

    public static void main(String[] args) {
        anyMatch();
    }
}
