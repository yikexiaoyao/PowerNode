package demo19;

class Circle {
    //属性
    private double radius;
    //构造方法
    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle() {}
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    //打印方法
    public void getArea() {
        System.out.println("圆的面积为：" + Math.PI * radius * radius);
    }
}
public class Test {
    public static void main(String[] args) {
        //创建对象
        Circle c = new Circle(1.0);
        c.getArea();
        c.setRadius(2.0);
        c.getArea();
    }
}
