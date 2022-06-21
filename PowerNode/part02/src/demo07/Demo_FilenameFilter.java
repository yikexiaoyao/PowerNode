package demo07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;

class Demo_FilenameFilter {
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
        File[] files = file.listFiles(new FilenameFilter(){
            @Override
            public boolean accept(File dir, String name) {
                //将文件名封装成File
                File file = new File(dir, name);
                return name.endsWith(".txt") || file.isDirectory();
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
