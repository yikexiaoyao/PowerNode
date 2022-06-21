package demo04;

import java.util.Collections;
import java.util.HashSet;

public class Demo01 {
    public static void main(String[] args) {
        //创建HashSet集合
        HashSet<String> set = new HashSet<>();
        Collections.addAll(set, "东", "西", "南", "北", "中");
        System.out.println("set=" + set);
    }
}
