package demo08;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;

public class Demo05 {
    public static void print(File file) throws FileNotFoundException {
        //判断
        if (file == null) {
            throw new NullPointerException("文件对象不能为空");
        }
        if (!file.exists()) {
            throw new FileNotFoundException("文件不存在");
        }
        if (file.isFile()) {
            throw new FileNotFoundException("不是目录");
        }
        //列举
        File[] files = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt") || file.isFile();
            }
        });
        //非空判断
        if(file!=null) {
            //遍历
            for (File dir : files) {
                if (dir.isFile()) {
                    System.out.println(dir);
                } else {
                    print(dir);
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        //创建File对象
        File file = new File("c:\\Users\\DELL\\Desktop");
        //调用自定义方法
        print(file);
    }
}
