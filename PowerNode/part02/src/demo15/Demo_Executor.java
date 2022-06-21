package demo15;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo_Executor {
    public static void main(String[] args) {
        //创建线程池对象
        ExecutorService es = Executors.newFixedThreadPool(2);
        //创建线程任务对象
        MyRunnable mr = new MyRunnable();
        es.submit(mr);
        es.submit(mr);
        es.submit(mr);
        //关闭线程池
        es.shutdown();
        //创建线程池对象
        ExecutorService es1 = Executors.newFixedThreadPool(2);
        es1.submit(mr);
        es1.submit(mr);
        es1.submit(mr);
        //关闭线程池
        es1.shutdown();
    }
}
