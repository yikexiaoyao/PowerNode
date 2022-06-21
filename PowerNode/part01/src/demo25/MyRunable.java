package demo25;

public interface MyRunable {
    public abstract void run();
}

class Car implements MyRunable {

    @Override
    public void run() {
        System.out.println("汽车在飞速行驶。。。");
    }
}

class Person implements MyRunable {

    @Override
    public void run() {
        System.out.println("人在快速地奔跑。。。");
    }
}

class Dog implements MyRunable {

    @Override
    public void run() {
        System.out.println("狗在快速地奔跑。。。");
    }
}