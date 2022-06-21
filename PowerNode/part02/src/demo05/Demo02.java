package demo05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Demo02 {
    public static void main(String[] args) {
        Collection<Student> col = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1、录入；0、退出");
            int type = sc.nextInt();
            if (type == 1) {
                System.out.print("姓名：");
                String name = sc.next();
                System.out.print("年龄：");
                int age = sc.nextInt();
                col.add(new Student(name, age));
            } else if (type == 0) {
                System.out.println("退出");
                break;
            } else {
                System.out.println("输入有误，请重新输入");
                continue;
            }
        }
        for (Student stu : col) {
            System.out.println(stu);
        }
    }
}
