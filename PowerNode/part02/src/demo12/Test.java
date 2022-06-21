package demo12;

public class Test {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("通过匿名字类实现多线程");
            }

            //特有方法
            public void show() {
                System.out.println("show run...");
            }
        };
        t.start();
        //多态对象无法访问子类的特有成员

        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("。。。。。。。。。。");
            }
        }) {
            @Override
            public void run() {
                System.out.println("..........");
            }
        }.start();
    }
}
