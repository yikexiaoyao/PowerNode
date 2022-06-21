package demo06;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "张三丰");
        map.put(2, "周芷若");
        map.put(3, "汪峰");
        map.put(4, "灭绝师太");
        for (Integer key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + "=" + value);
        }
        System.out.println("----------分割线----------");
        map.remove(1);
        for (Integer key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + "=" + value);
        }
        System.out.println("----------分割线----------");
        map.replace(2, "殷素素");
        for (Integer key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + "=" + value);
        }
    }
}
