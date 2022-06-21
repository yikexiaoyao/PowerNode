package demo06;

import java.util.*;

public class Demo04 {
    public static void main(String[] args) {
        //创建map集合
        Map<String, String> map = new HashMap<>();
        //保存数据
        map.put("1930", "乌拉圭");
        map.put("1934", "意大利");
        map.put("1938", "意大利");
        map.put("1950", "乌拉圭");
        map.put("1954", "西德");
        map.put("1958", "巴西");
        map.put("1962", "巴西");
        map.put("1966", "英格兰");
        map.put("1970", "巴西");
        map.put("1974", "西德");
        map.put("1978", "阿根廷");
        map.put("1982", "意大利");
        map.put("1986", "阿根廷");
        map.put("1990", "西德");
        map.put("1994", "巴西");
        map.put("1998", "法国");
        map.put("2002", "巴西");
        map.put("2006", "意大利");
        map.put("2010", "西班牙");
        map.put("2014", "德国");
        System.out.println("请输入年份：");
        //创建Scanner对象
        Scanner sc = new Scanner(System.in);
        String year = sc.next();
        //获取年份对应的value值
        String result = map.get(year);
        //判断获取的结果
        if (result != null) {
            System.out.println(year + "年获得世界杯冠军的国家是" + result);
        } else {
            System.out.println(year + "没有举办世界杯");
        }
        System.out.println("----------分割线----------");
        //获取世界杯的年份
        Set<String> keys = map.keySet();
        //创建集合
        Set<String> totalYearSet = new HashSet<>();
        System.out.println("请输入国家：");
        String country = sc.next();
        //遍历年份
        for (String key : keys) {
            //如果输入年份与获得冠军年份相等，则输入的国家赢得了冠军
            if (country.equals(map.get(key))) {
                //保存数据
                totalYearSet.add(key);
            }
        }
        //如果保存冠军年份的集合为空，则表示没有获得过冠军
        if (totalYearSet.isEmpty()) {
            System.out.println(country + "没有获得过世界杯冠军");
        } else {
            System.out.println(country + "获得世界杯冠军的年份是：" + totalYearSet);
        }
    }
}
