package demo16;

import java.util.function.Predicate;

public class Demo_Predicate {
    public static void test(Predicate<String> predicate, String str) {
        //接口对象调用方法
        boolean result = predicate.test(str);
        System.out.println("result=" + result);
    }

    public static void main(String[] args) {
        //匿名内部类
        test(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("www");
            }
        }, "www.bjpowernode.com");

        //Lambda表达式
        test((String s) -> {
            return s.endsWith("com");
        }, "www.bjpowernode.com");

        //Lambda表达式
        test(s -> s.endsWith("com"), "www.bjpowernode.com");
    }
}
