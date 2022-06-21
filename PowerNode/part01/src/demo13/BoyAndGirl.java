package demo13;

class Boy {
    //属性
    private String name;
    int age;
    //构造方法
    public Boy(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public  Boy() {}
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    //方法
    //喊
    public void shout() {
        if (age >= 23) {
            System.out.println(name + "说：我到了结婚的年龄了");
        }else{
            System.out.println("还是先谈个恋爱吧");
        }
    }
    //娶
    public void marry(Girl g) {
        System.out.println(name + "说：我要娶" + g.getName());
    }
}
class Girl {
    //属性
    private String name;
    int age;
    //构造方法
    public Girl(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Girl() {}
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    //嫁
    public void marry(Boy b) {
        System.out.println(name + "说：我要嫁给" + b.getName());
    }
}
public class BoyAndGirl {
    public static void main(String[] args) {
        //创建对象
        Boy b = new Boy("韦小宝", 23);
        Girl g1 = new Girl("双儿", 21);
        Girl g2 = new Girl("建宁",18);
        //调用方法
        b.shout();
        g1.marry(b);
        g2.marry(b);

        b.setName("张三");
        b.shout();
        g1.marry(b);
        g2.marry(b);
    }
}
