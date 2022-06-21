package demo05;

import java.util.*;

public class Demo01 {
    //自定义方法
    public static char[] prepare() {
        //创建原始字符数组
        /*char[] ascii = {
                //从0到9的数字
                48,49,50,51,52,53,54,55,56,57,
                //从A到Z的数字
                65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,
                //从a到z的数字
                97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122
        };*/
        char[] ascii = new char[62];
        //将0~9放入原始数组
        for (int i = 0; i <= 9; i++) {
            ascii[i] = (char) (i + 48);
        }
        //将A~Z放入原始数组
        for (int i = 10; i <= 35; i++) {
            ascii[i] = (char) (i + 55);
        }
        //将a~z放入原始数组
        for (int i = 36; i <= 61; i++) {
            ascii[i] = (char) (i + 61);
        }
        //创建六位字符数组
        char[] arr = new char[6];
        //创建Random对象
        Random random = new Random();
        //遍历原始数组
        for (int i = 0; i < arr.length; i++) {
            //锁定随机数范围，将原属数组中随机下标对应的元素放入六位数组
            arr[i] = ascii[random.nextInt(62)];
        }
        return arr;
    }

    public static void main(String[] args) {
        //创建集合
        Collection col = new ArrayList();
        //创建十个集合对象并保存
        Collections.addAll(col, new String(prepare()), new String(prepare()),
                new String(prepare()), new String(prepare()), new String(prepare()),
                new String(prepare()), new String(prepare()), new String(prepare()),
                new String(prepare()), new String(prepare()));
        //获取迭代对象
        Iterator it = col.iterator();
        //判断集合中是否还有元素
        while (it.hasNext()) {
            System.out.println("随机验证码：" + it.next());
        }
    }
}
