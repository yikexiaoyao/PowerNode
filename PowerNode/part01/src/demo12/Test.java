package demo12;

class Ren {
    String name;
    int age;
    String address;
    public Ren(String n, int a, String addr) {
        name = n;
        age = a;
        address = addr;
        System.out.println("我是Ren类中的三个参数的构造。。。");
    }
    public Ren() {
        System.out.println("我是Ren类中的空参数构造。。。");
    }
    //方法
    //打印信息
    public void getInfo() {
        System.out.println("姓名：" + name + "，年龄" + age + "，籍贯" + address);
    }
}
public class Test {
    public static void main(String[] args) {
        Ren r1 = new Ren("陈天宇" ,23 ,"靖江");
        Ren r2 = new Ren();
        r1.getInfo();
        r2.getInfo();
    }
}
