package demo12;

public class DieLock implements Runnable {
    //创建两把锁
    private Object lock_A = new Object();
    private Object lock_B = new Object();
    //创建变量，控制if语句的执行流程
    boolean flag = false;

    @Override
    public void run() {
        if(flag){
            //t1
            while (true){
                synchronized(lock_A){
                    System.out.println("if lock_A 锁。。。");
                    synchronized(lock_B){
                        System.out.println("if lock_B 锁。。。");
                    }
                }
            }
        }else {
            //t2
            synchronized(lock_B){
                System.out.println("else lock_B 锁。。。");
                synchronized(lock_A){
                    System.out.println("if lock_A 锁。。。");
                }
            }
        }
    }
}
