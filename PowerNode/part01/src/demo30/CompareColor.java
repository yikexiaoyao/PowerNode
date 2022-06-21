package demo30;

public class CompareColor implements CompareAble {
    @Override
    public void compare(Apple a1, Apple a2) {
        if (a1.getColor().equals(a2.getColor())) {
            System.out.println(a1);
        }else {
            System.out.println(a2);
        }
    }
}
