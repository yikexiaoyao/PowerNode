package demo06;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Demo03 {
    public static void method01(String str) {
        Set set = new HashSet();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            set.add(c);
        }
        System.out.println("去重后：" + set);
    }

    public static void method02(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (Character key : map.keySet()) {
            Integer value = map.get(key);
            System.out.println(key + "出现的次数为：" + value);
        }
    }

    public static void main(String[] args) {
        String str = "dsaahdkhdsaiuwefhsaasha";
        method01(str);
        method02(str);
    }
}
