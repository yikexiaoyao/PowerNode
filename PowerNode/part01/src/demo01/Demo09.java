package demo01;

public class Demo09 {
    public static void main(String[] args) {
        /*
        for循环
         */
        int sum = 0, amount = 0;
        for (int j = 1; j <= 100; j++) {
            //偶数
            if (j%2==0){
                System.out.println("一百以内的偶数");
                System.out.println(j);
                sum += j;
                amount++;
            }
        }

        /*
        while循环
        先判断，再执行
         */
        //偶数
        int sum1 = 0, amount1 = 0, i = 1;
        System.out.println("一百以内的偶数");
        while (i<=100){
            //偶数
            if (i%2==0){
                System.out.println(i);
                sum1 += i;
                amount1++;
            }
            i++;
        }

        /*
        do...while循环
        先执行，再判断
         */
        //奇数
        int sum2 = 0, amount2 = 0, m = 1;
        System.out.println("一百以内的奇数");
        do {
            //偶数
            if (m%2==1){
                System.out.println(m);
                sum2 += m;
                amount2++;
            }
            m++;
        }while (m<=100);

        System.out.println("一百以内的偶数和（for循环）");
        System.out.println(sum);
        System.out.println("一百以内的偶数个数（for循环）");
        System.out.println(amount);

        System.out.println("----------分割线----------");

        System.out.println("一百以内的偶数和（while循环）");
        System.out.println(sum1);
        System.out.println("一百以内的偶数个数（while循环）");
        System.out.println(amount1);

        System.out.println("----------分割线----------");

        System.out.println("一百以内的奇数和（do...while循环）");
        System.out.println(sum2);
        System.out.println("一百以内的奇数个数（do...while循环）");
        System.out.println(amount2);
    }
}
