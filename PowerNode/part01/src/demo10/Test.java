package demo10;

class People {
    //属性
    String name;
    private int age;

    //提供设置属性的方法
    public void setAge(int a) {
        if (a < 0 || a > 130) {
            System.out.println("年龄有误");
        } else {
            age = a;
        }
    }

    //提供获取age属性的方法
    public int getAge() {
        return age;
    }

    //打印方法
    public void getInfo() {
        System.out.println("姓名：" + name + "，年龄：" + age);
    }
}

public class Test {
    public static void main(String[] args) {
        //创建对象
        People p = new People();
        //对象属性赋值
        p.name = "张三";
        System.out.println(p.name);
        p.setAge(130);
        //int age = p.getAge();
        System.out.println(p.getAge());
        //对象调用方法
        p.getInfo();
    }
}
