package demo12;

public class Demo_DaemonThread {
    public static void main(String[] args) {
        //创建线程对象
        MyThread t = new MyThread();
        //设置守护线程
        t.setDaemon(true);
        System.out.println(t.isDaemon());
        //启动线程
        t.start();
        //主程序循环
        for (int i = 1; i <= 20; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}
