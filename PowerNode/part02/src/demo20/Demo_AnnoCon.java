package demo20;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo_AnnoCon {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取Person类的Class对象
        Class<?> aClass = Class.forName("demo20.Person");
        //获取构造方法对象
        Constructor<?> con = aClass.getDeclaredConstructor(String.class);
        //抑制权限
        con.setAccessible(true);
        //判断是否存在指定的注解
        boolean result = con.isAnnotationPresent(MyAnno.class);
        System.out.println("result=" + result);
        if (result) {
            //获取注解
            MyAnno annotation = con.getAnnotation(MyAnno.class);
            String name = annotation.value();
            //将注解的属性赋值给构造方法
            Object person = con.newInstance(name);
            System.out.println("person=" + person);
        }
    }
}
