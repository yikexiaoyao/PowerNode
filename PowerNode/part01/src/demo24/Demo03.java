package demo24;

public class Demo03 {
    public static void main(String[] args) {
        int i = 0, j = 0;
        //先判断再执行
        while (i < 10) {
            System.out.println("laoguo is a good man,laoguo is a nice man,laoguo is a handsome man");
            i++;
        }
        System.out.println("----------分割线----------");
        //先执行再判断
        do {
            System.out.println("laoguo is a good man,laoguo is a nice man,laoguo is a handsome man");
            j++;
        } while (j < 10);
    }
}
