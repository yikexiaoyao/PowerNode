package demo01;

public class Demo16 {
    public static void main(String[] args) {
        /*
             ******
             ******
             ******
             ******
             ******
         */
        //矩形
        //行
        for (int i = 1; i <=5 ; i++) {
            //列
            for (int j = 0; j <=5 ; j++) {
                System.out.print("*");
            }
            //换行
            System.out.println();
        }

        System.out.println("----------分割线----------");

        /*
             *
             **
             ***
             ****
             *****
         */
        //直角三角形
        //行
        for (int a = 1; a <=5 ; a++) {
            //列
            for (int b = 1; b <=a ; b++) {
                System.out.print("*");
            }
            //换行
            System.out.println();
        }

        System.out.println("----------分割线----------");

        /*
                 *****
                *****
               *****
              *****
             *****
         */
        //平行四边形
        //行
        for (int x = 1; x <=5 ; x++) {
            //列
            //输出空格
            for (int y = 1; y <= 5-x; y++) {
                System.out.print(" ");
            }
            //输出*
            for (int z = 1; z <=5; z++) {
                System.out.print("*");
            }
            //换行
            System.out.println();
        }

        System.out.println("----------分割线----------");

        /*
            1*1=1
            1*2=2	2*2=4
            1*3=3	2*3=6	3*3=9
            1*4=4	2*4=8	3*4=12	4*4=16
            1*5=5	2*5=10	3*5=15	4*5=20	5*5=25
            1*6=6	2*6=12	3*6=18	4*6=24	5*6=30	6*6=36
            1*7=7	2*7=14	3*7=21	4*7=28	5*7=35	6*7=42	7*7=49
            1*8=8	2*8=16	3*8=24	4*8=32	5*8=40	6*8=48	7*8=56	8*8=64
            1*9=9	2*9=18	3*9=27	4*9=36	5*9=45	6*9=54	7*9=63	8*9=72	9*9=81
         */
        //九九乘法表
        //行
        for (int m = 1; m <= 9; m++) {
            //列
            for (int n = 1; n <= m; n++) {
                //空一个TAB位置
                System.out.print(n + "*" + m + "=" + m * n + "\t");
            }
            //换行
            System.out.println();
        }

        System.out.println("----------分割线----------");

        /*
                 *
                ***
               *****
              *******
             *********
         */
        //三角形
        //行
        for (int k = 1; k <= 5; k++) {
            for (int p = 5; k <= p ; p--) {
                System.out.print(" ");
            }
            for (int p = 1; p <= k; p++) {
                System.out.print("*");
            }
            for (int p = 1; p < k; p++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
