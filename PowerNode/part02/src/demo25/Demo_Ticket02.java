package demo25;

/**
 * @author cty
 * @date 2021/9/3 9:22
 */
public class Demo_Ticket02 {
    public static void main(String[] args) {
        //创建对象
        Ticket02 t = new Ticket02();
        //创建线程任务
        Thread t1 = new Thread(t, "窗口一");
        Thread t2 = new Thread(t, "窗口一");
        Thread t3 = new Thread(t, "窗口一");
        //启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}
