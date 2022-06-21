package demo09;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo_Exception_JDK8 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //创建输入输出流对象
            fis = new FileInputStream("c:\\Users\\DELL\\Desktop\\1.txt");
            fos = new FileOutputStream("c:\\Users\\DELL\\Desktop\\2.txt");
            //创建数组保存读取的数据
            byte[] bytes = new byte[1024];
            //定义变量保存读取到的字节个数
            int len = 0;
            //读写
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                //非空判断
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                //非空判断
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
