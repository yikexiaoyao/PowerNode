package demo12;

class MyThread extends Thread {
    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println(getName() + i);
        }
    }
}
