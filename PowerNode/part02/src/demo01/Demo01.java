package demo01;

import java.util.ArrayList;
import java.util.Collection;

public class Demo01 {
    public static void main(String[] args) {
        //创建集合
        Collection col1 = new ArrayList();
        //保存数据
        col1.add(123);
        col1.add("abc");
        col1.add("abc");
        col1.add('a');
        col1.add(true);
        col1.add(new Object());
        System.out.println(col1);

        Collection col2 = new ArrayList();
        col2.addAll(col1);
        System.out.println("col2=" + col2);
    }
}
