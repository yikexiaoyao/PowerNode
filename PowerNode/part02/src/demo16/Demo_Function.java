package demo16;

import java.util.function.Function;

public class Demo_Function {
    //自定义方法，参数类型为Function接口类型
    public static void apply(Function<String, Integer> function, String str) {
        //通过接口对象调用方法
        Integer num = function.apply(str);
        System.out.println("num=" + num);
    }

    public static void main(String[] args) {
        //匿名内部类
        apply(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.valueOf(s) + 100;
            }
        }, "123");

        //Lambda表达式
        apply((String s) -> {
            return Integer.valueOf(s) + 123;
        }, "1000");

        //Lambda表达式
        apply(s -> Integer.valueOf(s) + 123, "1000");
    }
}
