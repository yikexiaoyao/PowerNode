package demo05;

import java.util.ArrayList;
import java.util.TreeSet;

public class Demo08 {
    public static void main(String[] args) {
        //创建集合对象
        ArrayList<Integer> list = new ArrayList<>();
        TreeSet<Integer> redBalls = new TreeSet<>();
        //生成6个随机数，范围1~33
        while (redBalls.size() < 6) {
            int a = (int) (Math.random() * 33 + 1);
            redBalls.add(a);
        }
        list.addAll(redBalls);
        //生成1个随机数
        int b = (int) (Math.random() * 16 + 1);
        list.add(b);
        //遍历打印所有号码
        System.out.print("双色球所有号码：");
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.print(list.get(i));
            } else {
                System.out.print(list.get(i) + ", ");
            }
        }
        //换行
        System.out.println();
        //遍历打印红球号码
        System.out.print("红球号码：");
        for (Integer r : redBalls) {
            if (r.equals(redBalls.last())) {
                System.out.print(r + " ");
            } else {
                System.out.print(r + ", ");
            }

        }
        //打印蓝球号码
        System.out.print("蓝色号码：" + b);
    }
}
