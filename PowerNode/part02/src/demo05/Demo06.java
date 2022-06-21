package demo05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Demo06 {
    public static int listTest(Collection<String> list, String s) {
        String str = list.toString();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c + "")) {
                Integer value = map.get(c + "");
                map.put(c + "", value + 1);
            } else {
                map.put(c + "", 1);
            }
        }
        return map.containsKey(s) ? map.get(s) : 0;
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
