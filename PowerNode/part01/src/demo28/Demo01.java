package demo28;

abstract class Father {
    public abstract void method();
}

public abstract class Demo01 {
    public static void main(String[] args) {
        //匿名子类重写抽象方法
        new Father() {
            @Override
            public void method() {
                System.out.println("hello 孩子");
            }
        }.method();
    }
}
