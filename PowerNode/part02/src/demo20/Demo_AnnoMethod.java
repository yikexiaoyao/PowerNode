package demo20;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo_AnnoMethod {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取Person类的Class对象
        Class<?> aClass = Class.forName("demo20.Person");
        //获取成员方法对象
        Method setName = aClass.getMethod("setName", String.class);
        if (setName.isAnnotationPresent(MyAnno.class)) {
            //获取注解对象
            MyAnno annotation = setName.getAnnotation(MyAnno.class);
            String value = annotation.value();
            //创建对象
            Object person = aClass.getConstructor().newInstance();
            setName.invoke(person, value);
            System.out.println("person=" + person);
        }
    }
}
