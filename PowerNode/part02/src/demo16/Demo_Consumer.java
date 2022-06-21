package demo16;

import java.util.function.Consumer;

public class Demo_Consumer {
    public static void main(String[] args) {
        //匿名内部类
        accept(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        }, 20);

        //Lambda表达式
        accept((Integer integer) -> {
            System.out.println(integer);
        }, 100);

        //Lambda表达式省略格式
        accept(integer -> System.out.println(integer), 100);

        //方法引用，优化Lambda表达式
        accept(System.out::println, 100);
    }

    //自定义方法，形参的类型为Consumer接口类型
    public static void accept(Consumer<Integer> consumer, int num) {
        //通过接口对象调用抽象方法
        consumer.accept(num);
    }
}
