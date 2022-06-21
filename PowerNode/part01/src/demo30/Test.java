package demo30;

public class Test {
    public static void main(String[] args) {
        //创建工人对象
        Worker w = new Worker();
        //创建苹果对象
        Apple a1 = new Apple(5, "青色");
        Apple a2 = new Apple(3, "红色");
        //调用方法
        System.out.println("默认挑大的");
        w.pickApple(new CompareBig(), a1, a2);
        System.out.println("挑红的");
        w.pickApple(new CompareColor(), a1, a2);
    }
}
