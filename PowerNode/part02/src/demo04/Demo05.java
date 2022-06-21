package demo04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Demo05 {
    public static void main(String[] args) {

        //创建集合对象
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 2, 9, 5, 1, 6, 7, 3, 8, 4);
        System.out.println(list);

        //升序
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        //降序
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        //升序
        Collections.sort(list);
        System.out.println(list);

        //降序
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

    }
}
