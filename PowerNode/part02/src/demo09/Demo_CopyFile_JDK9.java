package demo09;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo_CopyFile_JDK9 {
    public static void transferTo() throws IOException {
        //获取当前系统时间
        long time = System.currentTimeMillis();
        //创建输入输出流对象
        FileInputStream fis = new FileInputStream("c:\\Users\\DELL\\Desktop\\1.mp4");
        //读写
        long length = fis.transferTo(new FileOutputStream("c:\\Users\\DELL\\Desktop\\4.mp4"));
        System.out.println("length=" + length);
        //关闭流
        fis.close();
        System.out.println(System.currentTimeMillis() - time);
    }

    public static void readAllBytes() throws IOException {
        //获取当前系统时间
        long time = System.currentTimeMillis();
        //创建输入输出流对象
        FileInputStream fis = new FileInputStream("c:\\Users\\DELL\\Desktop\\1.mp4");
        FileOutputStream fos = new FileOutputStream("c:\\Users\\DELL\\Desktop\\3.mp4");
        //文件复制
        byte[] bytes = fis.readAllBytes();
        System.out.println(bytes.length);
        //写出
        fos.write(bytes);
        //关闭流
        fos.close();
        fis.close();
        System.out.println(System.currentTimeMillis() - time);
    }

    public static void main(String[] args) throws IOException {
        //获取当前系统时间
        long time = System.currentTimeMillis();
        //创建输入输出流对象
        FileInputStream fis = new FileInputStream("c:\\Users\\DELL\\Desktop\\1.mp4");
        FileOutputStream fos = new FileOutputStream("c:\\Users\\DELL\\Desktop\\2.mp4");
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
        System.out.println(System.currentTimeMillis() - time);
    }
}
