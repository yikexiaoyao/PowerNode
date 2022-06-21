package demo22;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IOException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //属性集
        Properties prop = new Properties();
        prop.load(new FileReader("xml.properties"));
        //获取数据
        String className = prop.getProperty("className");
        System.out.println("className=" + className);
        String fieldName = prop.getProperty("fieldName");
        System.out.println("fieldName=" + fieldName);
        String methodName = prop.getProperty("methodName");
        System.out.println("methodName=" + methodName);
        //反射类的Class文件
        Class<?> aClass = Class.forName(className);
        Object o = aClass.getConstructor().newInstance();
        //获取成员变量对象
        Field field = aClass.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(o,"李四");
        //获取成员方法对象
        Method method = aClass.getMethod(methodName);
    }
}
