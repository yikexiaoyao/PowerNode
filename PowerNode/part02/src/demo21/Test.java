package demo21;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取类的Class对象
        Class<?> aClass = Class.forName("demo21.MyJunit");
        //获取所有公开的构造方法
        Method[] methods = aClass.getMethods();
        //创建对象
        Object o = aClass.getConstructor().newInstance();
        //遍历，获取方法对象
        for (Method method : methods) {
            //判断是否存在注解
            if (method.isAnnotationPresent(MyTest.class)) {
                method.invoke(o);
            }
        }
    }
}
