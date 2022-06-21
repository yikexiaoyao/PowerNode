package demo07;

import java.io.File;

public class Demo_Field {
    public static void main(String[] args) {
        //获取文件名分隔符
        String separator = File.separator;
        System.out.println("separator=" + separator);
        char separatorChar = File.separatorChar;
        System.out.println("separatorChar=" + separatorChar);
        String path = "C:" + separator + "Users\\DELL\\Desktop\\test.txt";

        //获取路径名分隔符
        String pathSeparator = File.separator;
        System.out.println("pathSeparator=" + pathSeparator);
        char pathSeparatorChar = File.separatorChar;
        System.out.println("pathSeparatorChar=" + pathSeparatorChar);
    }
}
