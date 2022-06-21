package demo01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class Demo05 {
    public static void main(String[] args) {
        //创建集合对象
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("使用迭代器遍历集合");
        for (Iterator<Integer> it = list.iterator(); it.hasNext(); ) {
            //获取数据
            System.out.println(it.next() + " ");
        }
        //换行
        System.out.println();
        System.out.println("高级for循环");
        for (Integer num : list) {
            System.out.println(num + " ");
        }
        //换行
        System.out.println();
        System.out.println("下标遍历list集合");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " ");
        }
        //换行
        System.out.println();
        System.out.println("使用list集合的特有迭代器遍历");
        for (ListIterator<Integer> it = list.listIterator(5); it.hasPrevious(); ) {
            //获取数据
            Integer previous = it.previous();
            System.out.println(previous);
        }
    }
}
