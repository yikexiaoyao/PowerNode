package demo04;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return getAge() == person.getAge() && getName().equals(person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }
}

public class Demo02 {
    public static void main(String[] args) {
        //创建集合对象
        HashSet<Person> set = new HashSet();
        //创建People对象
        Person p1 = new Person("唐三藏", 38);
        Person p2 = new Person("孙悟空", 888);
        Person p3 = new Person("猪八戒", 380);
        Person p4 = new Person("沙和尚", 360);
        Person p5 = new Person("白龙马", 270);
        Person p6 = new Person("孙悟空", 888);
        //保存数据
        Collections.addAll(set, p1, p2, p3, p4, p5, p6);
        //遍历集合
        for (Person person : set) {
            System.out.println(person);
        }
    }
}
