package demo20;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo_Constructor {
    public static void main(String[] args) throws Exception {
        //获取Person类的Class对象
        Class<?> aClass = Class.forName("demo20.Person");
        //获取类中所有的构造方法对象
        Constructor<?>[] cons = aClass.getConstructors();
        for (Constructor con : cons) {
            System.out.println(con);
        }
        //获取给name赋值的构造方法
        Constructor<?> name_con = aClass.getDeclaredConstructor(String.class);
        //抑制访问权限
        name_con.setAccessible(true);

        Object person = name_con.newInstance("张胜男");
        System.out.println("person=" + person);
    }

    public static void publicCon() throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        //获取Person类的Class对象
        Class<?> aClass = Class.forName("demo20.Person");
        //获取类中的所有公开的构造方法
        Constructor<?>[] cons = aClass.getConstructors();
        for (Constructor con : cons) {
            System.out.println(con);
        }
        //获取指定的公开构造方法
        Constructor<?> age_con = aClass.getConstructor(int.class);
        Object person = age_con.newInstance(18);
        System.out.println("person=" + person);

        //获取空参的构造方法对象
        Constructor<?> constructor = aClass.getConstructor();
        Object person1 = constructor.newInstance();
        System.out.println("person1=" + person1);
    }
}
