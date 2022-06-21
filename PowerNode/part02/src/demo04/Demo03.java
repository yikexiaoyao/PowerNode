package demo04;

import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

class People implements Comparable<People> {
    String name;
    int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public People() {
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
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof People)) {
            return false;
        }
        People people = (People) o;
        return getAge() == people.getAge() && getName().equals(people.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    //年龄降序，年龄相同姓名升序
    @Override
    public int compareTo(People o) {
        int temp = o.age - this.age;
        return temp == 0 ? this.name.compareTo(o.name) : temp;
    }
}

public class Demo03 {
    public static void main(String[] args) {
        //创建集合对象
        TreeSet<People> set = new TreeSet<>();
        //创建People对象
        People p1 = new People("a唐三藏", 38);
        People p2 = new People("b孙悟空", 888);
        People p3 = new People("c猪八戒", 380);
        People p4 = new People("d沙和尚", 380);
        People p5 = new People("e白龙马", 270);
        //保存数据
        Collections.addAll(set, p1, p2, p3, p4, p5);
        //遍历集合
        for (People people : set) {
            System.out.println(people);
        }
        System.out.println("----------分割线----------");
        //创建集合对象，年龄升序，年龄相同姓名降序
        TreeSet<People> set1 = new TreeSet<>(new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                int temp = o1.getAge() - o2.getAge();
                return temp == 0 ? o2.getName().compareTo(o1.getName()) : temp;
            }
        });
        Collections.addAll(set1, p1, p2, p3, p4, p5);
        //遍历集合
        for (People people : set1) {
            System.out.println(people);
        }
    }
}
