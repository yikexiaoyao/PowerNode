package demo07;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;

public class Demo_FileFilter {
    public static void print(File file) throws FileNotFoundException {
        //判断
        if (file==null) {
            throw new NullPointerException("文件对象不能为空");
        }
        if (!file.exists()) {
            throw new FileNotFoundException("文件不存在");
        }
        if (file.isFile()) {
            throw new FileNotFoundException("不是目录");
        }
        //列举
        File[] files = file.listFiles(new FileFilter(){
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory() || pathname.getName().endsWith(".txt") && pathname.isFile();
            }
        });
        //非空判断
        if (files!=null) {
            //遍历
            for (File dir : files) {
                if (dir.isFile()) {
                    System.out.println(dir);
                }else {
                    print(dir);
                }
            }
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        //创建文件对象
        File file = new File("c:\\Users\\DELL\\Desktop");
        print(file);
    }
}
