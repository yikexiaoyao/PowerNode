package demo16;

class SportsMan {
    //属性
    String name;
    int age;
    static String nation;
    //构造方法
    public SportsMan(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public SportsMan() {}
    //打印信息
    public void getInfo() {
        System.out.println(name + "-----" + age + "-----" + nation);
    }
}
public class Test {
    public static void main(String[] args) {
        //创建对象
        SportsMan sm1 = new SportsMan("姚明", 42);
        SportsMan sm2 = new SportsMan("刘翔", 40);
        //类名访问操作静态属性
        SportsMan.nation = "巴基斯坦";

        sm1.getInfo();
        sm2.getInfo();
    }
}
