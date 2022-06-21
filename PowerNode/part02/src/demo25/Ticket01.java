package demo25;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cty
 * @date 2021/9/3 9:05
 */
public class Ticket01 implements Runnable {
    //定义车票变量
    private int num = 100;
    //创建接口对象
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        //获取锁
        while (true) {
            lock.lock();
            try {
                if (num > 0) {
                    System.out.print("车票：" + num + "，" + Thread.currentThread().getName() + "售出车票，");
                    num--;
                    System.out.println("剩余车票：" + num);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
