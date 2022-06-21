package demo09;

//人类
class Person {
    //属性
    String name;
    int age;
    char sex;

    //定义构造方法（三个参数）
    public Person(String n, int a, char s){
        name = n;
        age = a;
        sex = s;
    }

    //方法
    //打印信息
    public void getInfo() {
        System.out.println("姓名：" + name +"，年龄：" + age + "，性别：" + sex);
    }
}
public class Test {
    public static void main(String[] args) {
        //使用三个三个参数的构造方法创建对象
        Person p = new Person("张三", 20, '男');
        p.getInfo();
    }
}
