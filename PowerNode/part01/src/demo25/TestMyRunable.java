package demo25;

public class TestMyRunable {
    public static void main(String[] args) {
        //创建数组
        MyRunable[] MyRunable = new MyRunable[3];
        //创建对象
        MyRunable[0] = new Car();
        MyRunable[1] = new Person();
        MyRunable[2] = new Dog();
        //遍历打印
        for (int i = 0; i < MyRunable.length; i++) {
            MyRunable[i].run();
        }
    }
}
