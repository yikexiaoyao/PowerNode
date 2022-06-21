package demo15;

class Children {
    String name;
    int age;
    public Children(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Children() {}
    //非静态方法
    public void getInfo() {
        System.out.println("姓名：" + name + "，年龄：" +age);
    }
    //静态方法
    public static void study() {
        System.out.println("good good study, day day up!");
    }
}
public class Test {
    public static void main(String[] args) {
        //调用非静态方法
        Children c = new Children("韩梅梅", 19);
        c.getInfo();
        //调用静态方法
        Children.study();
    }
}
