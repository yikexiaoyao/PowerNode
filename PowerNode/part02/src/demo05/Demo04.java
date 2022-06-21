package demo05;

import java.util.ArrayList;
import java.util.Random;

public class Demo04 {
    public static void main(String[] args) {
        //创建Random对象
        Random rand = new Random();
        //创建集合
        ArrayList<Integer> list = new ArrayList<>();
        //遍历获取10个随机数
        for (int i = 0; i < 10; i++) {
            //定义变量接收随机数
            int num = rand.nextInt(100) + 1;
            //将随机数放入集合
            list.add(num);
        }
        //打印随机数集合
        System.out.println("10个随机值：" + list.toString());
        //创建最大值集合
        ArrayList<Integer> maxList = new ArrayList<>();
        //遍历获取3个最大值
        for (int i = 0; i < 3; i++) {
            //假设集合中第一个数最大
            Integer max = list.get(0);
            //遍历获取集合中的值与最大值进行比较
            for (int j = 0; j < list.size(); j++) {
                Integer num = list.get(j);
                //如果集合中元素大于最大值，则将元素值赋给最大值
                if (max < num) {
                    max = num;
                    //将最大值放入最大值集合
                    maxList.add(max);
                }
            }
            //如果集合中包含最大值，则删除最大值
            while (list.contains(max)) {
                list.remove(max);
            }
        }
        System.out.println("最大的3个数是：" + maxList.toString());
        System.out.println("删除后：" + list.toString());
    }
}
