package demo06;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeMap;

class Student {
    String name;
    int cn;
    int math;

    public Student(String name, int cn, int math) {
        this.name = name;
        this.cn = cn;
        this.math = math;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCn() {
        return cn;
    }

    public void setCn(int cn) {
        this.cn = cn;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", cn=" + cn +
                ", math=" + math + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return getCn() == student.getCn() && getMath() == student.getMath() && getName().equals(student.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCn(), getMath());
    }
}

public class Demo05 {
    public static void main(String[] args) {
        //创建集合，语文升序，数学降序
        TreeMap<Student, String> map = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int temp = o1.getCn() - o2.getCn();
                return temp == 0 ? o2.getMath() - o1.getMath() : temp;
            }
        });
        //保存数据
        map.put(new Student("小强", 88, 92), "sh2006");
        map.put(new Student("小红", 65, 88), "sh2006");
        map.put(new Student("小张", 88, 72), "sh2006");
        map.put(new Student("小李", 69, 92), "sh2006");
        map.put(new Student("大王", 65, 72), "sh2006");
        //遍历集合
        for (Student key : map.keySet()) {
            System.out.println(key);
        }
        System.out.println("----------分割线----------");
        //创建集合，数学升序，语文降序
        TreeMap<Student, String> map1 = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int temp = o1.getMath() - o2.getMath();
                return temp == 0 ? o2.getCn() - o1.getCn() : temp;
            }
        });
        //保存数据
        map1.put(new Student("小陈", 88, 92), "sh2006");
        map1.put(new Student("小赵", 65, 88), "sh2006");
        map1.put(new Student("小冯", 88, 72), "sh2006");
        map1.put(new Student("小钱", 69, 92), "sh2006");
        map1.put(new Student("大王", 65, 72), "sh2006");
        //遍历集合
        for (Student key : map1.keySet()) {
            System.out.println(key);
        }
    }
}
