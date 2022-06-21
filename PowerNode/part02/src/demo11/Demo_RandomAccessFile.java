package demo11;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Demo_RandomAccessFile {
    public static void main(String[] args) throws IOException {
        //创建随即流对象
        RandomAccessFile raf = new RandomAccessFile("c:\\Users\\DELL\\Desktop\\1.txt","rw");
        //设置读写的下标位置
        raf.seek(5);
        raf.write(99);
    }
}
