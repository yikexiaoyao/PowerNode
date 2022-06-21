package demo12;

public class Ticket03 extends Thread {
    public Ticket03() {
    }

    public Ticket03(String name) {
        super(name);
    }

    //定义车票
    private static int num = 100;
    //锁
    private static Object lock = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (num > 0) {
                    System.out.print("车票：" + num + "，" + Thread.currentThread().getName() + "售出车票，");
                    num--;
                    System.out.println("剩余车票：" + num);
                }
            }
        }
    }
}
