package demo01;

public class Demo11 {
    public static void main(String[] args) {
        int a = 10, b = 55, c = 15, max;
        max = a > b ? a : b;
        max = max > c ? max : c;
        System.out.println("最大值为：" + max);
    }
}
