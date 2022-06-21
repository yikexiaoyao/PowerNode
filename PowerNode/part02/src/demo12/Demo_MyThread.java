package demo12;

public class Demo_MyThread {
    public static void main(String[] args) {
        //创建子类对象
        MyThread mt = new MyThread();
        //启动线程任务
        //mt.run();
        //开启线程
        mt.start();
        //主线程的for循环
        for (int i = 1; i <= 20; i++) {
            System.out.println("来福。。。");
        }
    }
}
