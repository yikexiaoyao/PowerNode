package demo02;

public class Demo02 {
    //自定义方法 ==》 打印
    public static int getPrint(int a, int b){
        //定义形参
        int sum = a + b;
        //返回值
        return sum;
    }
    public static void main(String[] args) {
        //定义实参
        int a = 1, b = 2;
        //获取返回值
        int sum = getPrint(a, b);
        //打印
        System.out.println(sum);
    }
}
