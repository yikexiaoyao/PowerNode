package demo05;

import java.util.ArrayList;
import java.util.Collection;

public class Demo05 {
    public static int listTest(Collection<String> list, String s) {
        int count = 0;
        while (list.contains(s)) {
            list.remove(s);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            int a = (int) (97 + Math.random() * 26);
            char num = (char) a;
            list.add(String.valueOf(num));
        }
        System.out.println(list);
        System.out.println("a:" + listTest(list, "a"));
        System.out.println("b:" + listTest(list, "b"));
        System.out.println("c:" + listTest(list, "c"));
        System.out.println("x:" + listTest(list, "x"));
    }
}
