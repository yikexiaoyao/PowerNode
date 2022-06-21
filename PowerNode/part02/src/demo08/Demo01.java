package demo08;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;

public class Demo01 {
    private static int fileCount;
    private static int directoryCount;

    public static void getCount(File file) throws FileNotFoundException {
        //判断文件
        if (file == null) {
            throw new NullPointerException("文件对象不能为空");
        }
        if (!file.exists()) {
            throw new FileNotFoundException("文件不存在");
        }
        if (file.isFile()) {
            throw new FileNotFoundException("不是目录");
        }
        //列举当前目录
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory() || pathname.isFile();
            }
        });
        //判断非空
        if (files != null) {
            //遍历files数组
            for (File dir : files) {
                //判断类型
                if (dir.isFile()) {
                    fileCount++;
                } else {
                    directoryCount++;
                }
            }
        }
    }

    public static void main(String[] args) {
        //创建file对象
        File file = new File("d:\\");
        //调用方法
        try {
            getCount(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("文件的个数为：" + fileCount);
        System.out.println("文件夹的个数为：" + directoryCount);
    }
}
