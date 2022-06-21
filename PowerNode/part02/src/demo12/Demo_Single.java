package demo12;

public class Demo_Single {
    public static void main(String[] args) {
        //创建线程对象
        SingleRunnable sr = new SingleRunnable();
        //创建线程任务对象
        Thread sr1 = new Thread(sr);
        Thread sr2 = new Thread(sr);
        Thread sr3 = new Thread(sr);
        Thread sr4 = new Thread(sr);
        //启动线程
        sr1.start();
        sr2.start();
        sr3.start();
        sr4.start();
    }
}
