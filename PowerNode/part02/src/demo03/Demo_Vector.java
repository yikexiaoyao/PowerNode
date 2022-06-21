package demo03;

import java.util.Enumeration;
import java.util.Vector;

class Demo_Vector {
    public static void main(String[] args) {
        //创建对象
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        //获取特有的迭代器对象
        Enumeration<Integer> en = vector.elements();
        while (en.hasMoreElements()) {
            System.out.println(en.nextElement());
        }
    }
}
