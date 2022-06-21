package demo12;

public class Single {
    //创建锁对象
    private static Object lock = new Object();

    //私有构造方法
    private Single() {
    }

    //本类创建对象
    private static Single s = null;

    //提供返回本类对象的方法
    static Single getInstance() {
        //提高代码的执行效率
        if (s == null) {
            //同步
            synchronized (lock) {
                //判断
                if (s == null) {
                    s = new Single();
                }
            }
        }
        return s;
    }
}
