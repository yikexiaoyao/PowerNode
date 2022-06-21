package demo03;

public class Demo07 {
    //自定义方法之一般查找
    public static String search(int[] arr, int element) {
        for (int i = 0; i <= arr.length-1 ; i++) {
            if (arr[i] == element) {
                return element + "对应的下标为" + i;
            }
        }
        return "没有找到对应的下标";
    }
    public static void main(String[] args) {
        //创建数组
        int[] arr = {28,65,-13,92,81,15,55};
        //查找-13对应的下标
        String result = search(arr, -13);
        System.out.println(result);
    }
}
