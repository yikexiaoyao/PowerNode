package demo03;

public class Demo01 {
    public static void main(String[] args) {
        //静态数组
        int[] scores = {50, 60, 70, 80, 90, 100};
        //动态数组
        String[] names = new String[4];
        //打印长度
        System.out.println(scores.length);

        names[0] = "张三";
        names[names.length - 1] = "赵六";
        System.out.println(names[0] + "------" + names[names.length - 1]);

        //遍历
        for (int i = 0; i <=scores.length-1 ; i++) {
            System.out.println(scores[i]);
        }
    }
}
