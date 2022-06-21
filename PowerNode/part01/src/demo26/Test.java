package demo26;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Employee[] emps = new Employee[3];
        emps[0] = new Employee(2, "张三", 21, 8000.0);
        emps[1] = new Employee(1, "李四", 37, 10000.0);
        emps[2] = new Employee(3, "王五", 44, 12000.0);
        System.out.println("排序前：");
        for (int i = 0; i < emps.length; i++) {
            System.out.println(emps[i]);
        }
        System.out.println("----------分割线----------");
        System.out.println("排序后：");
        Arrays.sort(emps);
        for (int i = 0; i < emps.length; i++) {
            System.out.println(emps[i]);
        }
    }
}
