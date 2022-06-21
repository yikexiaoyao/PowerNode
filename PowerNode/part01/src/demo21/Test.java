package demo21;

//人类
abstract class Person {
    String name;
    int age;

    public abstract void eat();

    public abstract void walk();
}

//男人类
class Man extends Person {
    //独有属性
    boolean isSmoking;

    //重写抽象方法
    @Override
    public void eat() {
        System.out.println("大口吃...");
    }

    @Override
    public void walk() {
        System.out.println("大摇大摆...");
    }

    //独有方法
    public void entertainment() {
        System.out.println("花天酒地...");
    }
}

//女人类
class Woman extends Person {
    //独有属性
    boolean isBeauty;

    //重写构造方法
    @Override
    public void eat() {
        System.out.println("节食减肥...");
    }

    @Override
    public void walk() {
        System.out.println("扭扭捏捏...");
    }

    //独有方法
    public void shopping() {
        System.out.println("买买买...");
    }
}

public class Test {
    public static void test(Person p) {
        p.eat();
        p.walk();
        if (p instanceof Man) {
            //转换为Man类型
            Man m = (Man) p;
            m.entertainment();
        } else if (p instanceof Woman) {
            //转换为Woman类型
            Woman w = (Woman) p;
            w.shopping();
        }
    }

    public static void main(String[] args) {
        //多态
        Person p = new Woman();
        Woman w = (Woman) p;
        w.shopping();
        //多态
        Person p1 = new Man();
        //多态
        test(new Man());
        System.out.println();
        //多态
        test(new Woman());
    }
}
