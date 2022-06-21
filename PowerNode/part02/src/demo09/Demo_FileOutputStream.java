package demo09;

import java.io.FileOutputStream;
import java.io.IOException;

class Demo_FileOutputStream {
    public static void main(String[] args) throws IOException {
        //创建字节输出流对象
        FileOutputStream fos = new FileOutputStream("c:\\Users\\DELL\\Desktop\\1.txt");
        //写入数据
        fos.write(97);
        fos.write('a');
        //十进制 --> 二进制 1 0110 0001，保留后8位，0110 0001 二进制转十进制 --> 97
        fos.write(353);
        //定义数组
        byte[] bytes = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75};
        fos.write(bytes, 3, 5);
        //写入中文字符
        fos.write("你好啊".getBytes());
        //关闭流
        fos.close();
    }
}
