package demo15;

public class Demo_Lambda {
    public static void main(String[] args) {
        //创建线程任务对象
        MyRunnable mr = new MyRunnable();

        //创建线程任务
        Thread t1 = new Thread(mr);
        t1.start();

        //匿名内部类
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 1; i <= 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "..." + i);
                }
            }
        });
        t2.start();

        //Lambda表达式 ()->{}
        Thread t3 = new Thread(() -> {
            for (int i = 1; i <= 20; i++) {
                System.out.println(Thread.currentThread().getName() + "..." + i);
            }
        });
        t3.start();

        //Lambda表达式 ()->{}
        Thread t4 = new Thread(() -> System.out.println("省略模式运行线程。。。"));
        t4.start();
    }
}
