package demo11;

import java.io.*;

public class Demo01 {
    public static void read() throws IOException {
        //创建字符转字节输出流
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("c:\\Users\\DELL\\Desktop\\2.txt"));
        //写数据
        osw.write("动力节点");
        //关闭流
        osw.close();
    }

    public static void main(String[] args) throws IOException {
        //创建字节流对象，读取字节交给转换流转换
        FileInputStream fis = new FileInputStream("c:\\Users\\DELL\\Desktop\\1.txt");
        //创建字节转换字符输入流
        InputStreamReader isr = new InputStreamReader(fis, "gbk");
        //读数据
        char[] chars = new char[1024];
        int len = 0;
        while ((len = isr.read(chars)) != -1) {
            System.out.println(new String(chars, 0, len));
        }
        //关闭流
        fis.close();
        isr.close();
    }
}
