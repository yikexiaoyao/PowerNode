package demo04;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo10 {
    public static void main(String[] args) {
        //创建map集合
        HashMap<String, String> map = new HashMap<>();
        map.put("长白山", "吉林");
        map.put("红塔山", "桂林");
        map.put("黄山", "安徽");
        map.put("万寿山", "黑龙江");
        //获取键值对对象entry
        Set<Map.Entry<String, String>> entrys = map.entrySet();
        //遍历键值对对象
        for (Map.Entry<String, String> entry : entrys) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "=" + value);
        }
    }
}
