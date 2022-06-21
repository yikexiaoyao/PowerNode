package demo16;

import java.util.function.Supplier;

public class Demo_Supplier {

    //自定义方法，形参的类型为Supplier接口类型
    public static void get(Supplier<String> supplier) {
        //接口对象，调用get方法
        String s = supplier.get();
        System.out.println("s=" + s);
    }

    public static void main(String[] args) {
        //匿名内部类
        get(new Supplier<String>() {
            @Override
            public String get() {
                return "Hello World!";
            }
        });

        //Lambda表达式
        get(() -> {
            return "Hello World!";
        });
        //Lambda表达式省略格式
        get(() -> "Hello World!");
    }
}
