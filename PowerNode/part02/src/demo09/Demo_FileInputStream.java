package demo09;

import java.io.FileInputStream;
import java.io.IOException;

public class Demo_FileInputStream {
    public static void read() throws IOException {
        //创建字节输入流对象
        FileInputStream fis = new FileInputStream("c:\\Users\\DELL\\Desktop\\1.txt");
        //定义变量接收读取到的数据
        int a = 0;
        //读取数据
        while ((a = fis.read()) != -1) {
            System.out.println((char) a);
        }
        //关闭流
        fis.close();
    }

    public static void main(String[] args) throws IOException {
        //创建字节流输入对象
        FileInputStream fis = new FileInputStream("c:\\Users\\DELL\\Desktop\\1.txt");
        //创建数组保存读取到的字节数据，长度为1024的整数倍
        byte[] bytes = new byte[1024];
        //定义变量接收读取到的字节个数
        int len = 0;
        //读取数据
        while ((len = fis.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        //关闭流
        fis.close();
    }
}
