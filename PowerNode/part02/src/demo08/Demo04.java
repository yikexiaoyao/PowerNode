package demo08;

import java.io.File;
import java.io.FilenameFilter;

public class Demo04 {
    public static void print(File file) {
        //判断
        if (file == null) {
            throw new NullPointerException("文件对象不能为空");
        }
        if (!file.exists()) {
            throw new NullPointerException("文件不存在");
        }
        if (file.isFile()) {
            throw new NullPointerException("不是目录");
        }
        //列举
        String[] files = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File file = new File(dir, name);
                return file.isFile() || file.isDirectory();
            }
        });
        //非空判断
        if (files != null) {
            //遍历
            for (String dir : files) {
                //将String类型重新包装成File类型
                File file1 = new File(file, dir);
                if (file1.isFile()) {
                    //按 . 切割字符串并存入数组
                    String[] strs = dir.split("\\.");
                    System.out.println(dir + "  " +  "的文件类型是" + "   " + strs[strs.length-1]);
                }else {
                    print(file1);
                }
            }
        }
    }

    public static void main(String[] args) {
        //创建File对象
        File file = new File("c:\\Users\\DELL\\Desktop");
        print(file);
    }
}
