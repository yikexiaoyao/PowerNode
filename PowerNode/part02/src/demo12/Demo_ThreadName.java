package demo12;

public class Demo_ThreadName {
    public static void main(String[] args) {
        //创建线程对象
        MyThread mt1 = new MyThread();
        mt1.setName("来福");
        MyThread mt2 = new MyThread("小强。。。");
        //启动线程
        mt1.start();
        mt2.start();
        //主线程循环
        for (int i = 1; i <= 200; i++) {
            System.out.println(Thread.currentThread().getName() + "。。。。。。。。。。" + i);
        }
    }
}
