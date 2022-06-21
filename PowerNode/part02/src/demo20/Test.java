package demo20;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //创建集合
        ArrayList<String> list = new ArrayList<String>();
        list.add("abc");
        //保存其他数据类型
        //获取ArrayList的Class对象
        Class<? extends ArrayList> aClass = list.getClass();
        //反射add方法
        Method add = aClass.getMethod("add", Object.class);
        add.invoke(list, 123);
        add.invoke(list, true);
        System.out.println(list);
    }
}
