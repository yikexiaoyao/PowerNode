package demo20;

public class Person {

    //成员变量
    @MyAnno("张三")
    private String name;
    public int age;
    char sex;
    private static int num;

    //构造方法
    @MyAnno("李四")
    public Person(String name) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Person() {
    }

    //成员方法
    @MyAnno("王五")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        Person.num = num;
    }

    //静态成员方法
    public static void sleep() {
        System.out.println("Zzzzzzzzzz..........");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
