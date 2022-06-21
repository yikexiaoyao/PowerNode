package demo15;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ "线程任务被执行。。。。。");
    }
}
