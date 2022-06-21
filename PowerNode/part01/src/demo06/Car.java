/*
    步骤一：设计类
 */
package demo06;

public class Car {
    //颜色
    String color;
    //品牌
    String brand;
    //车牌
    String number;
    //价格
    double price;
    //方法（事物的行为）
    //行驶
    public void run() {
        System.out.println(color + "的" + brand + "，车牌号为" + number + "，价格为" + price + "￥，正在飞速地行驶...");
    }
    //停止
    public void stop() {
        System.out.println("车停了...");
    }
}
