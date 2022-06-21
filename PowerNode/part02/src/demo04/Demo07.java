package demo04;

import java.util.HashMap;

public class Demo07 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("西游记", "吴承恩");
        map.put("水浒传", "施耐庵");
        map.put("三国演义", "罗贯中");
        for (Object key : map.keySet()) {
            String value = (String) map.get(key);
            System.out.println(key + "=" + value);
        }
        System.out.println("----------分割线----------");
        //增
        map.putIfAbsent("红楼梦", "曹雪芹");
        for (Object key : map.keySet()) {
            String value = (String) map.get(key);
            System.out.println(key + "=" + value);
        }
        System.out.println("----------分割线----------");
        //改
        map.put("红楼梦", "陈天宇");
        for (Object key : map.keySet()) {
            String value = (String) map.get(key);
            System.out.println(key + "=" + value);
        }
        System.out.println("----------分割线----------");
        map.replace("红楼梦", "曹雪芹");
        for (Object key : map.keySet()) {
            String value = (String) map.get(key);
            System.out.println(key + "=" + value);
        }
        System.out.println("----------分割线----------");
        //删
        map.remove("红楼梦");
        for (Object key : map.keySet()) {
            String value = (String) map.get(key);
            System.out.println(key + "=" + value);
        }
    }
}
