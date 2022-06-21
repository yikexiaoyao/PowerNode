package demo01;

public class Demo10 {
    public static void main(String[] args) {
        int sum = 0, amount = 0;
        //一百以内
        for (int i = 1; i <= 100; i++) {
            //七的倍数
            if (i%7 == 0){
                //System.out.println(i);
                sum += i;
                amount++;
            }
        }
        System.out.println(amount);
        System.out.println(sum);
    }
}
