package demo14;

public class Set implements Runnable {

    //创建资源容器对象
    Resource resource;

    public Set(Resource resource) {
        this.resource = resource;
    }

    public Set() {
    }

    //生产者线程任务，往容器中保存商品
    @Override
    public void run() {
        while (true) {
            try {
                resource.set("哇哈哈");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
