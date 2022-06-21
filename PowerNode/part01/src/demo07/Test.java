package demo07;

class Num {
    //定义成员变量
    int i = 10;
    public void test() {
        //定义局部变量
        int i = 100;
        //就近原则
        System.out.println("成员变量i=" + this.i);
        System.out.println("局部变量i=" + i);
    }
}
public class Test {
    public static void main(String[] args) {
        Num t = new Num();
        t.test();
    }
}
