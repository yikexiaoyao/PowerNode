package demo20;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Demo_Field {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //获取Person类的Class对象
        Class<?> aClass = Class.forName("demo20.Person");
        //获取类中的所有成员变量
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        //创建Person对象
        Object person = aClass.getConstructor().newInstance();
        System.out.println("person=" + person);
        //获取公开的成员变量age
        Field age = aClass.getField("age");
        age.set(person, 20);
        System.out.println("person=" + person);
        Object ageValue = age.get(person);
        System.out.println("ageValue =" + ageValue);
        ////////////////////////////////////////
        //获取私有静态成员变量num
        Field num = aClass.getDeclaredField("num");
        //抑制访问权限
        num.setAccessible(true);
        num.set(null, 100);
        System.out.println(num.get(null));
    }
}
