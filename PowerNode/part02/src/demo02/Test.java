package demo02;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        //创建集合
        ArrayList<Student> list = new ArrayList<>();
        //创建学生对象
        Student stu1 = new Student("刘备", 33);
        Student stu2 = new Student("关羽", 30);
        Student stu3 = new Student("张飞", 25);
        Student stu4 = new Student("赵云", 23);
        //保存对象
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        list.add(stu4);
        System.out.println("list=" + list);
        //foreach遍历集合
        for (Student stu : list) {
            System.out.println(stu);
        }
    }
}
