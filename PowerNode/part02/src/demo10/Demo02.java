package demo10;

import java.io.*;

public class Demo02 {
    public static void read03() throws IOException {
        try {
            //创建输入输出流对象
            FileInputStream fis = new FileInputStream("c:\\Users\\DELL\\Desktop\\1.jpg");
            FileOutputStream fos = new FileOutputStream("c:\\Users\\DELL\\Desktop\\4.jpg");
            byte[] bytes = fis.readAllBytes();
            fos.write(bytes);
            //关闭流
            fos.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void read02() throws IOException {
        try {
            //创建输入输出流对象
            FileInputStream fis = new FileInputStream("c:\\Users\\DELL\\Desktop\\1.jpg");
            FileOutputStream fos = new FileOutputStream("c:\\Users\\DELL\\Desktop\\3.jpg");
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
            //关闭流
            fos.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read01() throws IOException {
        try {
            //创建输入输出流对象
            FileInputStream fis = new FileInputStream("c:\\Users\\DELL\\Desktop\\1.jpg");
            FileOutputStream fos = new FileOutputStream("c:\\Users\\DELL\\Desktop\\2.jpg");
            //读写
            int a;
            while ((a = fis.read()) != -1) {
                fos.write(a);
            }
            //关闭流
            fos.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        read01();
    }
}
