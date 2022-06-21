package demo11;

import java.io.*;

public class Demo_BufferedByte {
    public static void copy02() throws IOException {
        //获取当前系统时间
        long time = System.currentTimeMillis();
        //创建对象
        FileInputStream fis = new FileInputStream("c:\\Users\\DELL\\Desktop\\1.mp4");
        FileOutputStream fos = new FileOutputStream("c:\\Users\\DELL\\Desktop\\3.mp4");
        //缓冲流
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        //读写
        int a = 0;
        while ((a = bis.read()) != -1) {
            bos.write(a);
        }
        //关闭流
        bis.close();
        bos.close();
        fis.close();
        fos.close();
        System.out.println(System.currentTimeMillis() - time);
    }

    public static void copy01() throws IOException {
        //获取当前系统时间
        long time = System.currentTimeMillis();
        //创建对象
        FileInputStream fis = new FileInputStream("c:\\Users\\DELL\\Desktop\\1.mp4");
        FileOutputStream fos = new FileOutputStream("c:\\Users\\DELL\\Desktop\\2.mp4");
        //读写
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }
        //关闭流
        fos.close();
        fis.close();
        System.out.println(System.currentTimeMillis() - time);
    }

    public static void main(String[] args) throws IOException {
        copy02();
    }
}
