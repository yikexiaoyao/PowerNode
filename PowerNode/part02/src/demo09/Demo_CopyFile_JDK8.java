package demo09;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo_CopyFile_JDK8 {
    public static void read() throws IOException {
        //创建输入输出流对象
        FileInputStream fis = new FileInputStream("c:\\Users\\DELL\\Desktop\\1.txt");
        FileOutputStream fos = new FileOutputStream("c:\\Users\\DELL\\Desktop\\2.txt");
        //定义变量保存读取到的数据
        int a = 0;
        //读写
        while ((a = fis.read()) != -1) {
            fos.write(a);
        }
        //关闭流
        fos.close();
        fis.close();
    }

    public static void main(String[] args) throws IOException {
        //创建输入输出流对象
        FileInputStream fis = new FileInputStream("c:\\Users\\DELL\\Desktop\\1.txt");
        FileOutputStream fos = new FileOutputStream("c:\\Users\\DELL\\Desktop\\3.txt");
        //创建数组保存读取的数据
        byte[] bytes = new byte[8192];
        //定义变量保存读取到的字节个数
        int len = 0;
        //读写
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }
        //关闭流
        fos.close();
        fis.close();
    }
}
