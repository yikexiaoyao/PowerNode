package demo22;

abstract class Person {
    public abstract void eat();

    public abstract void toilet();
}

class Man extends Person {

    @Override
    public void eat() {
        System.out.println("大口吃饭");
    }

    @Override
    public void toilet() {
        System.out.println("内急");
    }

    public void smoke() {
        System.out.println("抽烟");
    }
}

class Woman extends Person {

    @Override
    public void eat() {
        System.out.println("节食减肥");
    }

    @Override
    public void toilet() {
        System.out.println("排队上厕所");
    }

    public void makeup() {
        System.out.println("化妆两小时");
    }
}

public class Test {
    public static void meeting(Person ps) {
        ps.eat();
        ps.toilet();
        if (ps instanceof Man) {
            Man mn = (Man) ps;
            mn.smoke();
        } else if (ps instanceof Woman) {
            Woman wm = (Woman) ps;
            wm.makeup();
        }
    }

    public static void main(String[] args) {
        Person ps1 = new Man();
        Man mn = (Man) ps1;
        Person ps2 = new Woman();
        Woman wn = (Woman) ps2;

        meeting(mn);
        System.out.println("----------分割线----------");
        meeting(wn);
    }
}
