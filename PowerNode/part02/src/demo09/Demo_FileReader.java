package demo09;

import java.io.FileReader;
import java.io.IOException;

public class Demo_FileReader {
    public static void read02() throws IOException {
        //创建字符输出流对象
        FileReader fr = new FileReader("c:\\Users\\DELL\\Desktop\\1.txt");
        //写数据
        char[] chars = new char[1024];
        //定义变量接收读取到的字符个数
        int len = 0;
        while ((len = fr.read(chars)) != -1) {
            System.out.println((char) len);
        }
        //关闭流
        fr.close();
    }

    public static void read01() throws IOException {
        //创建字符输出流对象
        FileReader fr = new FileReader("c:\\Users\\DELL\\Desktop\\1.txt");
        //定义变量保存读取到的数据
        int a = 0;
        while ((a = fr.read()) != -1) {
            System.out.println((char) a);
        }
        fr.close();
    }

    public static void main(String[] args) throws IOException {
        read02();
    }
}
