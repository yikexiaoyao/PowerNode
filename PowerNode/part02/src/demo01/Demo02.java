package demo01;

import java.util.ArrayList;
import java.util.Collection;

public class Demo02 {
    public static void main(String[] args) {
        //创建集合
        Collection col1 = new ArrayList();
        //保存数据
        col1.add("东邪");
        col1.add("西毒");
        col1.add("南帝");
        col1.add("北丐");
        col1.add("中神通");
        col1.add("杨康");
        System.out.println("col1=" + col1);
        //删除集合中指定元素
        boolean remove = col1.remove("杨康");
        System.out.println("remove=" + remove);
        System.out.println("col1=" + col1);
        //清空集合中所有元素
        col1.clear();
        System.out.println("col1=" + col1);
        //创建集合
        Collection col2 = new ArrayList();
        col2.addAll(col1);
        col2.add("郭靖");
        col2.add("黄蓉");
        System.out.println("col2=" + col2);
        //删除集合中的所有元素
        boolean removeAll = col2.removeAll(col1);
        System.out.println("removeAll=" + removeAll);
        System.out.println("col2=" + col2);
        //删除集合中不存在的元素(保留集合中存在的元素)
        boolean retainAll = col2.retainAll(col1);
        System.out.println("retainAll=" + retainAll);
        System.out.println("col2=" + col2);
    }
}
