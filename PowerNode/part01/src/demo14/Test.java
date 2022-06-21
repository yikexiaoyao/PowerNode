package demo14;

class Dog {
    //属性
    String name;
    int age;
    //创建构造方法
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Dog() {}
    public String ComparedByDog(Dog d) {
        return this.age == d.age ? "年龄相等" : "年龄不等";
    }
}
public class Test {
    public static void main(String[] args) {
        //创建对象
        Dog d1 = new Dog("旺财", 3);
        Dog d2 = new Dog("来福", 7);
        String result = d1.ComparedByDog(d2);
        System.out.println(result);
    }
}
