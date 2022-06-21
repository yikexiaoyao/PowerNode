package demo01;

public class Demo19 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 100; i < 1000 ; i++) {
            //个位
            int a = i % 10;
            //十位
            int b = i / 10 % 10;
            //百位
            int c = i / 100 % 10;
            //判断是否满足条件
            if (i == a * a * a + b * b * b + c * c * c){
                System.out.println(i + "是水仙花数");
                count++;
            }
            /*
            if (i == Math.pow(a,3) + Math.pow(b,3) + Math.pow(c,3)){
                System.out.println(i + "是水仙花数");
                count++;
            }
             */
        }
        System.out.println("一共" + count + "个水仙花数");
    }
}
