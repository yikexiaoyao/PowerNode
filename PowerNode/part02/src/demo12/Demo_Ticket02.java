package demo12;

public class Demo_Ticket02 {
    public static void main(String[] args) {
        //创建线程对象
        Ticket02 ticket = new Ticket02();
        //创建线程任务对象
        Thread t1 = new Thread(ticket, "窗口一");
        Thread t2 = new Thread(ticket, "窗口二");
        Thread t3 = new Thread(ticket, "窗口三");
        Thread t4 = new Thread(ticket, "窗口四");
        //启动线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
