package demo15;

import java.io.File;
import java.io.FileFilter;

public class Demo_FileFilter {
    public static void main(String[] args) {
        //创建File对象
        File file = new File("c:\\Users\\DELL\\Desktop");
        //列举
        File[] files = file.listFiles(new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".mp4");
            }
        });

        //遍历
        for (File dir : files) {
            System.out.println(dir);
        }
        System.out.println("----------分割线----------");
        //列举
        File[] files1 = file.listFiles((File pathname) -> {
            return pathname.getName().endsWith(".mp4");
        });
        //遍历
        for (File dir : files1) {
            System.out.println(dir);
        }
    }
}
