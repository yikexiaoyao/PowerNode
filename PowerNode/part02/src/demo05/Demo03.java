package demo05;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo03 {
    //生成十个随机数的集合
    public static ArrayList<Integer> prepare() {
        //创建集合
        ArrayList<Integer> list1 = new ArrayList<>();
        //循环遍历
        while (list1.size() < 10) {
            //定义变量接收随机数
            int a = (int) (Math.random() * 50 + 1);
            //如果集合中不包含定义的随机数，则添加进入集合
            if (!list1.contains(a)) {
                list1.add(a);
            }
        }
        return list1;
    }

    public static ArrayList<Integer> input() {
        //创建集合
        ArrayList<Integer> list2 = new ArrayList<>();
        //创建Scanner对象
        Scanner scanner = new Scanner(System.in);
        //循环遍历
        while (list2.size() < 10) {
            System.out.println("请输入第" + (list2.size() + 1) + "个数字[1~50]");
            //定义变量接收输入值
            int b = scanner.nextInt();
            //锁定范围
            if (b >= 1 && b <= 50) {
                //如果集合中不包含定义的随机数，则添加进入集合
                if (!list2.contains(b)) {
                    list2.add(b);
                    continue;
                } else {
                    //如果集合中包含定义的随机数，则提示重新输入
                    System.out.println("数字已存在，请重新输入第" + (list2.size() + 1) + "个数字");
                    continue;
                }
            } else {
                System.out.println("超出范围,请重新输入");
                continue;
            }
        }
        scanner.close();
        return list2;
    }

    public static void main(String[] args) {
        //创建集合接收自定义方法返回值
        ArrayList<Integer> input = input();
        ArrayList<Integer> prepare = prepare();
        System.out.println("您输入的号码为：" + input);
        System.out.println("乐透号码为：" + prepare);
        //定义计数器
        int count = 0;
        //遍历
        for (int i = 0; i < prepare.size(); i++) {
            //如果prepare集合中包含input元素，则计数器自增
            if(prepare.contains(input.get(i))){
                count++;
            }
        }
        System.out.println("猜中了：" + count + "个数字");
    }
}
