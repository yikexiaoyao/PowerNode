package demo05;

import java.util.*;

class Children implements Comparable<Children> {
    String name;
    int age;
    double score;

    public Children(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public Children() {
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Children{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Children)) {
            return false;
        }
        Children children = (Children) o;
        return getAge() == children.getAge() && Double.compare(children.getScore(), getScore()) == 0 && getName().equals(children.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getScore());
    }

    //成绩降序，成绩相同年龄升序
    @Override
    public int compareTo(Children o) {
        double temp = o.score - this.score;
        return temp == 0 ? this.age - o.age : (int) temp;
    }
}

public class Demo09 {
    public static void main(String[] args) {
        ArrayList<Children> list = new ArrayList<>();
        Children c1 = new Children("liusan", 20, 90.0);
        Children c2 = new Children("lisi", 22, 90.0);
        Children c3 = new Children("wangwu", 20, 90.0);
        Children c4 = new Children("sunliu", 22, 100.0);
        Collections.addAll(list, c1, c2, c3, c4);
        System.out.println("按照成绩和年龄排序：");
        for (Children c : list) {
            System.out.println(c);
        }
        //按照姓名排序
        TreeSet<Children> set = new TreeSet<>(new Comparator<Children>() {
            @Override
            public int compare(Children o1, Children o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        Collections.addAll(set, c1, c2, c3, c4);
        System.out.println("按照姓名排序：");
        for (Children ch : set) {
            System.out.println(ch);
        }
    }
}
