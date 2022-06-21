package demo07;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo_get {
    public static void main(String[] args) {
        //创建File对象
        File file1 = new File("c:\\Users\\DELL\\Desktop\\abc.txt");
        File file2 = new File("abc.txt");
        //获取绝对路径
        System.out.println(file1.getAbsolutePath());
        System.out.println(file2.getAbsolutePath());
        //获取文件路径
        System.out.println(file1.getPath());
        System.out.println(file2.getPath());
        //获取文件名称
        System.out.println(file1.getName());
        System.out.println(file2.getName());

        //创建文件对象
        File file = new File("c:\\Users\\DELL\\Desktop\\abc.txt");
        //获取最后一次修改时间
        long time = file.lastModified();
        System.out.println("time=" + time);
        Date date = new Date(time);
        System.out.println("date=" + date);
        //格式化
        String format = new SimpleDateFormat("yyyy年MM月dd日, HH:mm:ss").format(date);
        System.out.println("format=" + format);

        //获取文件长度
        long length = file.length();
        System.out.println("length=" + length);
    }
}
