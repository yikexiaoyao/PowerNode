package demo09;

import java.io.FileWriter;
import java.io.IOException;

public class Demo_FileWriter {
    public static void main(String[] args) throws IOException {
        //创建字符输出流对象
        FileWriter fw = new FileWriter("c:\\Users\\DELL\\Desktop\\1.txt");
        //写数据
        char[] chars = {97, 98, 99, 100, 101, 102, 103, 104, 105};
        fw.write(chars);
        //关闭流
        fw.close();
    }
}
