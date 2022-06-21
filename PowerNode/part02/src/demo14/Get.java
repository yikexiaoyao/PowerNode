package demo14;

public class Get implements Runnable {

    //创建资源容器对象
    Resource resource;

    public Get(Resource resource) {
        this.resource = resource;
    }

    public Get() {
    }

    //消费者任务线程
    @Override
    public void run() {
        while (true) {
            try {
                resource.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
