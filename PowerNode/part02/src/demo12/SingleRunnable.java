package demo12;

public class SingleRunnable implements  Runnable {

    @Override
    public void run() {
        //获取单例对象
        Single instance = Single.getInstance();
        System.out.println(instance);
    }
}
