package demo14;

public class Demo {
    public static void main(String[] args) {
        //创建资源容器对象
        Resource resource = new Resource();
        //创建生产者的线程任务对象
        Set set =new Set(resource);
        //创建消费者的线程任务对象
        Get get = new Get(resource);
        //创建生产者线程对象
        Thread set_t1 = new Thread(set, "生产者1");
        Thread set_t2 = new Thread(set, "生产者2");
        //创建消费者线程对象
        Thread get_t1 = new Thread(get, "消费者1");
        Thread get_t2 = new Thread(get, "消费者2");
        //启动线程
        set_t1.start();
        set_t2.start();
        get_t1.start();
        get_t2.start();
    }
}
