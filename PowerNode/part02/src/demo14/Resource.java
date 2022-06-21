package demo14;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {
    //创建数组
    private String[] strs = new String[1];
    //定义计数器
    private int count = 1;
    //创建锁对象
    private Lock lock = new ReentrantLock();
    //创建生产者Condition对象
    Condition con_set = lock.newCondition();
    //创建消费者Cndition对象
    Condition con_get = lock.newCondition();

    //添加商品
    public void set(String name) throws InterruptedException {
        //获取锁对象
        lock.lock();
        try {
            //判断容器中是否有商品存在
            while (strs[0] != null) {
                //生产者等待
                con_set.await();
            }
            //将商品添加到容器的0坐标下
            strs[0] = name + count;
            System.out.println(Thread.currentThread().getName() + "保存商品。。。。。" + strs[0]);
            //模拟保存商品的时间
            Thread.sleep(1);
            count++;
            //唤醒消费者
            con_set.signal();
        } finally {
            //释放锁
            lock.unlock();
        }

    }

    //取出商品
    public void get() throws InterruptedException {
        lock.lock();
        try {
            //判断容器中是否存在商品
            while (strs[0] == null) {
                //消费者等待
                con_get.await();
            }
            //重置容器空间
            strs[0] = null;
            //模拟取出商品
            System.out.println(Thread.currentThread().getName() + "取出商品。。。。。" + strs[0]);
            //模拟取出商品的时间
            Thread.sleep(1);
            //唤醒生产者
            con_get.signal();
        } finally {
            //释放锁
            lock.unlock();
        }
    }
}
