package demo12;

public class Ticket01 implements Runnable {
    //定义车票变量
    private int num = 100;
    //创建锁对象
    private Object lock = new Object();

    //线程任务  买票
    @Override
    public void run() {
        //使用死循环模拟窗口一直卖票
        while (true) {
            //同步代码模块
            synchronized (lock) {
                //判断是否还有票
                if (num > 0) {
                    //使用输出语句模拟售票
                    System.out.print("车票：" + num + "，" + Thread.currentThread().getName() + "售出车票，");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //迭代车票
                    num--;
                    System.out.println("剩余车票：" + num);
                }
            }

        }
    }

}
