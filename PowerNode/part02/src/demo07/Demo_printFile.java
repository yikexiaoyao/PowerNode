package demo07;

import java.io.File;

public class Demo_printFile {
    public static void printFile(File file) {
        //强壮性判断
        if (file == null) {
            throw new NullPointerException("文件对象不能为空");
        }
        if (!file.exists()) {
            try {
                throw new NullPointerException("当前文件路径不存在");
            } catch (NullPointerException e) {
                //不做任何处理
            }
        }
        if (file.isFile()) {
            throw new NullPointerException("不是目录类型");
        }
        //列举目录
        File[] files = file.listFiles();
        //判断文件是否为空
        if (files != null) {
            //遍历目录
            for (File dir : files) {
                //判断文件对象类型
                if (dir.isFile()) {
                    System.out.println(dir);
                } else {
                    //递归继续遍历
                    printFile(dir);
                }
            }
        }
    }

    public static void main(String[] args) {
        //创建文件对象
        File file = new File("c:\\Users\\DELL\\Desktop");
        printFile(file);
    }
}
