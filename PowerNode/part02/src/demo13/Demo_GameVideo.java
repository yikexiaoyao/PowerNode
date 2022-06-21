package demo13;

public class Demo_GameVideo {
    public static void main(String[] args) {
        //创建线程对象
        GameVideo gv = new GameVideo();
        //创建线程任务对象
        Thread t1 = new Thread(gv,"看电影");
        Thread t2 = new Thread(gv, "打游戏");
        //启动线程
        t1.start();
        t2.start();
    }
}
