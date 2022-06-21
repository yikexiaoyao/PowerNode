package demo13;

public class GameVideo implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            play();
        }
    }

    public static synchronized void play() {
        System.out.println(Thread.currentThread().getName());
    }
}
