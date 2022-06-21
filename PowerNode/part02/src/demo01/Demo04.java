package demo01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Demo04 {
    public static void main(String[] args) {
        //创建集合
        Collection coll = new ArrayList();
        //保存数据
        coll.add("三国");
        coll.add("西游");
        coll.add("水浒");
        coll.add("红楼");
        //获取迭代对象
        Iterator iterator = coll.iterator();
        //判断集合中是否还有元素
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
        System.out.println("----------分割线----------");
        //判断集合中是否还有元素
        for (Iterator it = coll.iterator(); it.hasNext(); ) {
            //获取数据
            Object next = it.next();
            System.out.println(next);
        }
        System.out.println("----------分割线----------");
        for (Object obj : coll) {
            System.out.println(obj);
        }
    }
}
