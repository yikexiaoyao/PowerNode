package demo15;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable {
    //定义变量
    private int num = 100;
    //创建接口对象
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            //获取锁
            lock.lock();
            try {
                if (num > 0) {
                    System.out.print("车票：" + num + "，" + Thread.currentThread().getName() + "售出车票，");
                    num--;
                    System.out.println("剩余车票：" + num);
                }
            } finally {
                //释放锁
                lock.unlock();
            }
        }
    }
}
