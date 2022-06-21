package demo03;

public class Demo09 {
    public static void count(char[] arr) {
        //定义长度26的数组
        char[] check = new char[26];
        //遍历
        for (int i = 0; i <= check.length-1 ; i++) {
            //初始化
            int count = 0;
            //将字母放入数组
            check[i] = (char) (97 +i);
            for (int j = 0; j <= arr.length-1 ; j++) {
                //判断是否重复
                if (check[i] == arr[j]) {
                    count++;
                }
            }
            /*
            a--1
            b--2
            c--0
            d--0
            e--0
            f--2
            g--0
            h--0
            i--0
            j--0
            k--0
            l--1
            m--1
            n--1
            o--1
            p--0
            q--0
            r--0
            s--1
            t--0
            u--0
            v--0
            w--0
            x--0
            y--0
            z--0
             */
            if (count != 0) {
                System.out.println(check[i] + "--" +count);
            }
        }
    }
    public static void main(String[] args) {
        char[] arr = {'a', 'l', 'f', 'm', 'f', 'o', 'b', 'b', 's', 'n'};
        count(arr);
    }
}
