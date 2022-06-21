package demo25;

/**
 * @author cty
 * @date 2021/9/3 9:10
 */
public class Demo_Ticket01 {
    public static void main(String[] args) {
        //创建对象
        Ticket01 t = new Ticket01();
        //创建线程对象
        Thread t1 = new Thread(t, "窗口一");
        Thread t2 = new Thread(t, "窗口二");
        Thread t3 = new Thread(t, "窗口三");
        //启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}
