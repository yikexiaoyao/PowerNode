package demo16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class Test {
    public static void main(String[] args) {

        List<String> one = new ArrayList<>();
        Collections.addAll(one, "迪丽热巴", "宋远桥", "苏星河", "老子", "庄子", "孙子", "洪七公");
        List<String> two = new ArrayList<>();
        Collections.addAll(two, "古力娜扎", "张无忌", "张三丰", "赵丽颖", "张二狗", "张天爱", "张三");

        // 第一个队伍只要名字为3个字的成员姓名
        ArrayList<String> one_a = new ArrayList<>();
        for (String name : one) {
            if (name.length() == 3) {
                one_a.add(name);
            }
        }

        // 第一个队伍筛选之后只要前3个人
        ArrayList<String> one_b = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            one_b.add(one_a.get(i));
        }

        //第二个队伍只要姓张的成员姓名
        ArrayList<String> two_a = new ArrayList<>();
        for (String name : two) {
            if (name.startsWith("张")) {
                two_a.add(name);
            }
        }

        //第二个队伍筛选之后不要前两个人
        ArrayList<String> two_b = new ArrayList<>();
        for (int i = 2; i < two_a.size(); i++) {
            two_b.add(two_a.get(i));
        }

        //将两个队伍合并为一个队伍
        ArrayList<String> one_two = new ArrayList<>();
        one_two.addAll(one_b);
        one_two.addAll(two_b);

        //根据姓名创建Person对象
        for (String name : one_two) {
            System.out.println(new Person(name));
        }

        System.out.println("----------分割线----------");

        //Lambda表达式
        Stream.concat(
                one.stream().filter(name -> name.length() == 3).limit(3),
                two.stream().filter(name -> name.startsWith("张")).skip(2)
        ).map(name -> new Person(name)).forEach(person -> System.out.println(person));
    }
}
