package demo08;

class Prepare {
    int a;
}
public class Test {
    public static void update(Prepare p) {
        p.a += 10;
    }
    public static void update(int a) {
        a += 10;
    }
    public static void main(String[] args) {
        Prepare p = new Prepare();
        p.a = 10;
        update(p);
        System.out.println(p.a);

        int a = 10;
        update(a);
        System.out.println(a);
    }
}
