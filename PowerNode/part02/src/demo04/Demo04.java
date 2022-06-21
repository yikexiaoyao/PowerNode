package demo04;

import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

class MyComparator implements Comparator<Integer> {
    int num;

    public MyComparator(int num) {
        this.num = num;
    }

    public MyComparator() {
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "MyComparator{" +
                "num=" + num +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MyComparator)) {
            return false;
        }
        MyComparator that = (MyComparator) o;
        return getNum() == that.getNum();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNum());
    }

    //降序
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }

}

public class Demo04 {
    public static void main(String[] args) {
        //默认升序排列
        TreeSet<Integer> set = new TreeSet<>();
        Collections.addAll(set, 2, 9, 5, 1, 6, 7, 3, 8, 4);
        System.out.println(set);

        //自定义降序
        MyComparator mc = new MyComparator();
        TreeSet<Integer> set1 = new TreeSet<>(mc);
        Collections.addAll(set1, 2, 9, 5, 1, 6, 7, 3, 8, 4);
        System.out.println(set1);
    }
}
