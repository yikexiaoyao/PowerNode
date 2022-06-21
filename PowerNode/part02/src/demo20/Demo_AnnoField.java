package demo20;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Demo_AnnoField {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取Person类的Class对象
        Class<?> aClass = Class.forName("demo20.Person");
        //获取成员变量对象
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        //判断
        if (name.isAnnotationPresent(MyAnno.class)) {
            //获取
            MyAnno annotation = name.getAnnotation(MyAnno.class);
            //获取注解成员
            String value = annotation.value();
            //创建Person对象
            Object person = aClass.getConstructor().newInstance();
            name.set(person, value);
            System.out.println("person=" + person);
        }
    }
}
