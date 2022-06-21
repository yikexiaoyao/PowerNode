package demo31;

public class Test {
    public static void main(String[] args) {
        //创建工人对象
        Worker w = new Worker();
        //创建苹果对象
        Apple a1 = new Apple(5.0, "青色");
        Apple a2 = new Apple(3.0, "红色");
        //调用匿名内部类接口
        w.pickApple(new CompareAble() {
            @Override
            public void compare(Apple a1, Apple a2) {
                System.out.println("默认挑大的");
                if (a1.getSize() > a2.getSize()) {
                    System.out.println(a1);
                }else {
                    System.out.println(a2);
                }
                System.out.println("挑红的");
                if (a1.getColor().equals(a2.getColor())) {
                    System.out.println(a1);
                }else {
                    System.out.println(a2);
                }
            }
        }, a1, a2);
    }
}
