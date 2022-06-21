package demo20;

//几何图形 ==》 抽象类
abstract class GgometricObject {
    //计算面积
    public abstract double getArea();
}

//圆类
class Circle extends GgometricObject {
    //属性
    private double radius;

    //构造方法
    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle() {
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    //重写抽象方法
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

//矩形类
class Rectangle extends GgometricObject {
    //属性
    private double length;
    private double width;

    //构造方法
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public Rectangle() {
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    //重写构造方法
    @Override
    public double getArea() {
        return length * width;
    }
}

public class Test {
    public static void main(String[] args) {
        //创建对象
        Circle c1 = new Circle(1.0);
        Rectangle r = new Rectangle(1.0, 2.0);

        //计算面积
        System.out.println("圆的面积是：" + c1.getArea());
        System.out.println("矩形的面积是：" + r.getArea());

        //引用类型数组
        GgometricObject[] gos = new GgometricObject[7];
        gos[0] = new Circle(1.0);
        //多态
        gos[gos.length-1] = new Rectangle(1.0, 2.0);
        //遍历数组
        for (int i = 0; i < gos.length; i++) {
            if (gos[i] != null) {
                System.out.println(gos[i].getArea());
            }
        }
    }
}
