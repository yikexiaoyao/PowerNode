package demo10;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        try {
            //创建输入输出流对象
            FileWriter fw = new FileWriter("c:\\Users\\DELL\\Desktop\\1.txt");
            FileReader fr = new FileReader("c:\\Users\\DELL\\Desktop\\1.txt");
            //写出HelloWorld
            fw.write("HelloWorld");
            //刷新数据
            fw.flush();
            //读写
            int a;
            while ((a = fr.read()) != -1) {
                System.out.println((char) a);
            }
            //关闭流
            fr.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
