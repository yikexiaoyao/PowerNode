package demo01;

public class Demo15 {
    public static void main(String[] args) {
        for (int i = 1; i <= 150 ; i++) {
            if (i%3 == 0 && i%5 == 0 && i%7 == 0){
                //3、5、7的倍数
                System.out.println(i + "foo" + "biz" + "baz");
            }else if (i%3 == 0 && i%5 == 0){
                //3、5的倍数
                System.out.println(i + "foo" + "biz");
            }else if (i%3 == 0 && i%7 == 0){
                //3、7的倍数
                System.out.println(i + "foo" + "baz");
            }else if (i%5 == 0 && i%7 == 0){
                //5、7的倍数
                System.out.println(i + "biz" + "baz");
            }else if (i%3 == 0){
                //3的倍数
                System.out.println(i + "foo");
            }else if (i%5 == 0){
                //5的倍数
                System.out.println(i + "biz");
            }else if (i%7 == 0){
                //7的倍数
                System.out.println(i + "baz");
            }else {
                //其他
                System.out.println(i);
            }
        }

        System.out.println("----------分割线----------");

        int j = 1;
        while (j <= 150) {
            System.out.print(j);
            if (j%3 == 0){
                //3的倍数
                System.out.print(" foo");
            }
            if (j%5 == 0){
                //5的倍数
                System.out.print(" biz");
            }if (j%7 == 0){
                //7的倍数
                System.out.print(" baz");
            }
            j++;
            System.out.println();
        }
    }
}
