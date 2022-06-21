package demo15;

public class Demo_Ticket {
    public static void main(String[] args) {
        //创建线程任务对象
        Ticket t = new Ticket();
        //创建线程对象
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        Thread t4 = new Thread(t);
        //启动线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
