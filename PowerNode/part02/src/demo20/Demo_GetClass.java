package demo20;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class Demo_GetClass {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Class<Integer> integerClass = int.class;
        Class<ArrayList> arrayListClass = ArrayList.class;
        Class<Person> personClass = Person.class;
        Class<int[]> aClass = int[].class;
        //通过getClass()方法获取
        Person p = new Person();
        Class<? extends Person> aClass1 = p.getClass();
        System.out.println("aClass1=" + aClass1);
        int[] arr = new int[4];
        Class<? extends int[]> aClass2 = arr.getClass();
        System.out.println("aClass2=" + aClass2);
        double[] dous = new double[3];
        Class<? extends double[]> aClass3 = dous.getClass();
        System.out.println("aClass=" + aClass3);

        //通过Class类中的forName方法
        Properties prop = new Properties();
        //获取配置文件中的数据到集合中
        prop.load(new FileReader("prop.properties"));
        //获取数据
        String className = prop.getProperty("className");
        Class<?> person = Class.forName(className);
        System.out.println("person=" + person);
    }
}
