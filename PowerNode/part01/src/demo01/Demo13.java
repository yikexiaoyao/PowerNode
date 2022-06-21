package demo01;

public class Demo13 {
    public static void main(String[] args) {
        int x = 1, y = 1;

        /*
        if (x++ == 2 & ++y ==2){
            x=7;
        }
        System.out.println("x=" + x + ",y=" + y);
        */

        /*
        if (x++ == 2 && ++y ==2){
            x=7;
        }
        System.out.println("x=" + x + ",y=" + y);
        */

        /*
        if (x++ == 1 | ++y ==1){
            x=7;
        }
        System.out.println("x=" + x + ",y=" + y);
        */

        if (x++ == 1 || ++y ==1){
            x=7;
        }
        System.out.println("x=" + x + ",y=" + y);

    }
}
