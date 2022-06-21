package demo04;

import java.util.HashMap;

public class Demo11 {
    public static void main(String[] args) {
        //定义字符串
        String str = "yvirikgsgvckgjgxwhsqrfkcbnetbk";
        //创建map集合
        HashMap<Character, Integer> map = new HashMap<>();
        //遍历字符串
        for (int i = 0; i < str.length(); i++) {
            //获取字符
            char c = str.charAt(i);
            /*//判断获取的字符在集合中是否存在
            if (map.containsKey(c)) {
                //存在，获取次数
                Integer value = map.get(c);
                //次数 +1 后保存
                map.put(c, value + 1);
            } else {
                //不存在
                map.put(c, 1);
            }*/
            //语法简介，可读性差
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }
        //遍历map集合
        for (Character key : map.keySet()) {
            //获取value
            Integer value = map.get(key);
            System.out.println(key + "出现的次数是：" + value);
        }
    }
}
