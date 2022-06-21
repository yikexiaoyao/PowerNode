package demo04;

import java.util.HashMap;
import java.util.Set;

public class Demo09 {
    public static void main(String[] args) {
        //创建集合
        HashMap<String, String> map = new HashMap<>();
        map.put("长江", "中国");
        map.put("黄河", "中国");
        map.put("黄浦江", "上海");
        map.put("西湖", "杭州");
        //获取key
        Set<String> keys = map.keySet();
        //遍历
        for (String key : keys) {
            //通过key获取value
            String value = map.get(key);
            System.out.println(value);
        }
    }
}
