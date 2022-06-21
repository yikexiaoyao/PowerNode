package demo06;

import java.util.HashMap;
import java.util.Map;

public class Demo06 {
    public static void main(String[] args) {
        String str = "If you want to change your fate I think you must come to the ujiuye to learn java";
        //创建集合
        Map<String, Integer> map = new HashMap<>();
        //按空格切割字符串并存入数组
        String[] strs = str.split(" ");
        //遍历字符串数组
        for (int i = 0; i < strs.length; i++) {
            //获取字符串数组中的字符串数据
            String a = strs[i];
            //判断字符串字符串在集合中是否存在
            if (map.containsKey(a)){
                //如果存在则计数器+1
                int count = map.get(a);
                map.put(a, count+1);
            }else{
                //如果不存在则默认次数为1
                map.put(a, 1);
            }
        }
        //遍历集合
        for (String key : map.keySet()){
            //获取value值
            int value = map.get(key);
            System.out.println(key + "出现的次数是：" + value);
        }
    }
}
