package demo06;

public class TestCar {
    public static void main(String[] args) {
        //步骤二：创建Car类的对象 ==》 实例化对象
        Car c1 = new Car();
        System.out.println(c1);

        //步骤三：通过对象调用方法
        c1.run();
        //步骤三：通过对象调用属性
        //设置属性值
        c1.color = "红色";
        c1.brand = "BYD";
        c1.number = "沪A88888";
        c1.price = 300000.0;

        c1.run();

        Car c2 = new Car();

        c2.run();

        //将从中的值复制一份给吃
        Car c3 = c1;
        c3.run();

        System.out.println(c2);
        System.out.println(c3);
    }
}
