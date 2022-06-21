package demo12;

public class Demo_ThreadPriority {
    public static void main(String[] args) {
        //创建线程对象
        MyThread t1 = new MyThread("优先级1");
        MyThread t2 = new MyThread("优先级2。。。");
        MyThread t3 = new MyThread("优先级3。。。。。");
        //设置优先级
        t1.setPriority(1);
        t3.setPriority(10);
        //启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}
