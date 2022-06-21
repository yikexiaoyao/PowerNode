package demo25;

/**
 * @author cty
 * @date 2021/9/3 9:16
 */
public class Ticket02 extends Thread {
    public Ticket02() {
    }

    public Ticket02(String name) {
        super(name);
    }

    //定义车票变量
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
