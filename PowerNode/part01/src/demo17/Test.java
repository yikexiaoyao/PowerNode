package demo17;

class Employee {
    //属性
    int id;
    String name;
    int age;
    double salary;
    //构造方法
    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public Employee() {}
    //打印方法
    public void getInfo() {
        System.out.println("编号：" + id +"，姓名：" + name + "，年龄：" + age + "，薪资：" + salary);
    }
}
public class Test {
    public static void main(String[] args) {
        //创建对象
        Employee e1 = new Employee();
        Employee e2 = new Employee();
        //属性赋值
        e1.id = 1001;
        e1.name = "张三";
        e1.age = 31;
        e1.salary = 10000.0;

        e2.id = 1002;
        e2.name = "李四";
        e2.age = 27;
        e2.salary = 12000.0;
        //调用方法
        e1.getInfo();
        e2.getInfo();
    }
}
