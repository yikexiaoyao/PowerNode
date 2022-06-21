package demo08;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;

public class Demo03 {
    public static void printFileTree(File file, int level) throws FileNotFoundException {
        if (file == null) {
            throw new NullPointerException("文件对象不能为空");
        }
        if (!file.exists()) {
            throw new FileNotFoundException("文件不存在");
        }
        if (file.isFile()) {
            throw new FileNotFoundException("不是目录");
        }
        //定义变量控制目录树的缩进，第一次递归为根目录
        String retract = "";
        //每递归一次缩进3个空格
        for (int i = 0; i < level; i++) {
            retract += "   ";
        }
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory() || pathname.isFile();
            }
        });
        if (files != null) {
            //遍历文件数组
            for (File dirs : files) {
                System.out.println(retract + dirs.getAbsolutePath());
                //判断是否为目录
                if (dirs.isDirectory()) {
                    printFileTree(dirs, level + 1);
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        //创建file对象
        File file = new File("e:\\");
        //打印文件目录名
        System.out.println(file.getName());
        printFileTree(file, 1);
    }
}
