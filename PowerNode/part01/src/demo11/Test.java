package demo11;

class Student {
    //属性
    String name;
    int age;
    char sex;

    //定义构造方法
    public Student(String n, int a, char s) {
        name = n;
        age = a;
        sex = s;
    }

    //方法
    //打印
    public void getInfo() {
        System.out.println("姓名：" + name + "，年龄" + age + "性别" + sex);
    }
}

public class Test {
    public static void main(String[] args) {
        //使用三个参数的构造方法创建Student对象
        Student s = new Student("张三", 20, '男');
        s.getInfo();
    }
}
