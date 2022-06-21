package demo01;

import java.util.ArrayList;
import java.util.Collection;

public class Demo03 {
    public static void main(String[] args) {
        //创建集合
        Collection col1 = new ArrayList();
        //保存数据
        col1.add("武大郎");
        col1.add("潘金莲");
        col1.add("西门庆");
        col1.add("王宝强");
        col1.add("马蓉");
        //集合中是否包含指定元素
        boolean contains = col1.contains("李小鹏");
        System.out.println("contains=" + contains);
        //创建集合
        Collection col2 = new ArrayList();
        //保存数据
        col2.add(col1);
        col2.add("李小鹏");
        //集合中是否包含指定元素
        boolean containsAll = col2.containsAll(col1);
        System.out.println("containsAll=" + containsAll);
        //集合是否相等
        boolean equals = col2.equals(col1);
        System.out.println(equals);
        //集合是否为空
        boolean empty = col2.isEmpty();
        System.out.println(empty);
    }
}
