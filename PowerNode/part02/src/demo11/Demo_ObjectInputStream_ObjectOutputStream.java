package demo11;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

class Pig {
    String name;
    int age;

    public Pig(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Pig() {
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
        return "Pig{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pig)) {
            return false;
        }
        Pig pig = (Pig) o;
        return getAge() == pig.getAge() && getName().equals(pig.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }
}
public class Demo_ObjectInputStream_ObjectOutputStream {
    public static void write() throws IOException {
        //创建序列化对象
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("c:\\Users\\DELL\\Desktop\\1.txt")
        );
        //创建对象
        Pig pig1 = new Pig("佩奇1", 1);
        Pig pig2 = new Pig("佩奇2", 10);
        Pig pig3 = new Pig("佩奇3", 100);
        Pig pig4 = new Pig("佩奇4", 1000);
        Pig pig5 = new Pig("佩奇5", 10000);
        //将需要序列化的对象保存到集合中，然后序列化集合
        ArrayList<Pig> list = new ArrayList<>();
        Collections.addAll(list, pig1, pig2, pig3, pig4, pig5);
        //序列化保存对象集合
        oos.writeObject(list);
        //关闭流
        oos.close();
    }

    //反序列化
    public static void read() throws IOException, ClassNotFoundException {
        //创建反序列化对象
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("c:\\Users\\DELL\\Desktop\\1.txt")
        );
        //反序列化
        ArrayList<Pig> list = (ArrayList<Pig>) ois.readObject();
        for (Pig pig : list) {
            System.out.println(pig);
        }
        //关闭流
        ois.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        read();
    }
}
