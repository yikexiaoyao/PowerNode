package demo09;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReader_FileWriter_Test {
    public static void main(String[] args) throws IOException {
        //创建输入输出流
        FileReader fr = new FileReader("c:\\Users\\DELL\\Desktop\\1.txt");
        FileWriter fw = new FileWriter("c:\\Users\\DELL\\Desktop\\2.txt");
        //读写
        int len = 0;
        char[] chars = new char[1024];
        while ((len = fr.read(chars)) != -1) {
            fw.write(chars, 0, len);
        }
        //关闭流
        fw.close();
        fr.close();
    }
}
