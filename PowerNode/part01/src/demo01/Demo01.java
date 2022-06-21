package demo01;

public class Demo01 {
    public static void main(String[] args){
        System.out.println("HelloWorld");

        //情况一
        int a,m=1;
        a=m++;
        //先赋值
        System.out.println(a);
        //后自增
        System.out.println(m);

        //情况二
        int b,n=1;
        b=++n;
        //后赋值
        System.out.println(b);
        //先自增
        System.out.println(n);

        System.out.println("----------分割线----------");

        int i=1, j=2;
        /*
        1、i++ ==> 先输出1，再自增1
        2、++j ==> 先自增1，再输出3
        3、混合运算
         */
//        System.out.println(i++ * j + ++j);
//
//        System.out.println("----------分割线----------");

        System.out.println(++i + j * ++i);

        System.out.println("----------分割线----------");

        int x = 3, y;
        y = (x++) + (++x) + (x++) * 2 + x +(++x);
        //  3       5       5           6   7
        System.out.println("x=" + x);
        System.out.println("y=" + y);

        System.out.println("----------分割线----------");

        int k = 10, p = 20, t;
        /*
        t = k;
        k = p;
        p = t;
         */
        t = k + p;
        k = t - k;
        p = t - p;
        System.out.println("k=" + k);
        System.out.println("p=" + p);
    }
}
