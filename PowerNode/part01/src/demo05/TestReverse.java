package demo05;

public class TestReverse {
    public static void main(String[] args) {
        //定义数组
        int[] arr = {1, 2, 3, 4, 5};
        //创建Demo35类的对象
        Reverse rev = new Reverse();
        System.out.println("反转前");
        //通过Demo35类的对象调用打印方法
        rev.printArray(arr);
        //通过Demo35类的对象调用反转方法
        rev.reverse(arr);
        System.out.println("反转后");
        //通过Demo35类的对象调用打印方法
        rev.printArray(arr);
    }
}
