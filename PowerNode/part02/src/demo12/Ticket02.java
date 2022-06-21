package demo12;

public class Ticket02 implements Runnable {
    //定义变量，模拟售票
    private static int num = 100;

    @Override
    public void run() {
        while (true) {
            ticket();
        }
    }

    //用于售票的方法
    public static synchronized void ticket() {
        //判断是否还有票
        if (num > 0) {
            System.out.print("车票：" + num + "，" + Thread.currentThread().getName() + "售出车票，");
            num--;
            System.out.println("剩余车票：" + num);
        }
    }
}
