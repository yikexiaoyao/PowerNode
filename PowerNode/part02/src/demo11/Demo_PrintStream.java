package demo11;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Demo_PrintStream {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream out = System.out;
        PrintStream err = System.err;
        System.out.write(97);
        System.out.println(97);

        //创建打印流对象
        PrintStream ps = new PrintStream("c:\\Users\\DELL\\Desktop\\1.txt");
        ps.println(97);
        ps.write(97);

        //设置打印的目标
        System.setOut(ps);
        System.out.println("Hello World!");
    }
}
