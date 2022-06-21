package demo03;

import java.util.Collections;

class Demo_LinkedList {
    public static void main(String[] args) {
        java.util.LinkedList<String> list = new java.util.LinkedList();
        Collections.addAll(list, "萧峰", "段誉", " 虚竹");
        System.out.println("list=" + list);
        list.addFirst("阿紫");
        System.out.println("list=" + list);
        list.addFirst("阿朱");
        System.out.println("list=" + list);
        list.add("段延庆");
        list.addLast("段正淳");
        System.out.println("list=" + list);
        String first = list.getFirst();
        System.out.println("first=" + first);
        String last = list.getLast();
        System.out.println("last=" + last);
        String removeFirst = list.removeFirst();
        System.out.println("removeFirst=" + removeFirst);
        String removeLast = list.removeLast();
        System.out.println("removeLast=" + removeLast);
        System.out.println("list=" + list);
    }
}
