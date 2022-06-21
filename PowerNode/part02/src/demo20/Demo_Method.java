package demo20;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo_Method {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        //获取Person类的Class对象
        Class<?> aClass = Class.forName("demo20.Person");
        //反射类中的所有成员方法
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        //创建对象
        Object person = aClass.getConstructor().newInstance();
        //获取setName方法
        Method setName = aClass.getMethod("setName", String.class);
        setName.invoke(person, "张三");
        System.out.println(person);
        //获取getName方法
        Method getName = aClass.getMethod("getName");
        Object nameValue = getName.invoke(person);
        System.out.println("nameValue=" + nameValue);

        //获取私有静态的成员方法
        Method sleep = aClass.getDeclaredMethod("sleep");
        //抑制权限
        sleep.setAccessible(true);
        //运行方法
        sleep.invoke(null);
    }
}
