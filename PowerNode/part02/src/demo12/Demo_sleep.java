package demo12;

public class Demo_sleep {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            System.out.println("第" + i + "秒");
            Thread.sleep(1000);
        }
        System.out.println("叮铃铃");
    }
}
