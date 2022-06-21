package demo12;

public class Demo_MyRunnable {
    public static void main(String[] args) {
        //创建实现类对象（线程任务对象） --> 指定线程任务
        MyRunnable mr = new MyRunnable();
        //创建Thread对象
        Thread t1 = new Thread("旺财");
        Thread t2 = new Thread("小强。。。");
        //启动线程
        t1.start();
        t2.start();
    }
}
