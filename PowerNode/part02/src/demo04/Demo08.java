package demo04;

import java.util.Collection;
import java.util.HashMap;

public class Demo08 {
    public static void main(String[] args) {
        //创建集合对象
        HashMap<String, String> map = new HashMap<>();
        map.put("黄山","安徽");
        map.put("长白山","吉林");
        map.put("松山","河南");
        map.put("峨眉山","四川");
        //获取map集合的所有value值
        Collection<String> values = map.values();
        //遍历保存value的集合
        for(String value : values) {
            System.out.println(value);
        }
    }
}
