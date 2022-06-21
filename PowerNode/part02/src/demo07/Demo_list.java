package demo07;

import java.io.File;

public class Demo_list {
    public static void main(String[] args) {
        //创建File对象
        File file = new File("C:\\Users\\DELL\\Desktop");
        //列举目录下的所有文件名
        String[] fileNames = file.list();
        for (String name : fileNames) {
            //判断
            if (name.endsWith(".txt")) {
                System.out.println(name);
            }
        }
        System.out.println("--------------------");
        //列举目录下的所有子目录文件对象
        File[] files = file.listFiles();
        for (File dir : files) {
            //判断
            if (dir.isFile()) {
                System.out.println(dir + "..........是文件");
            } else {
                System.out.println(dir + ".....是目录");
            }
        }
        //获取系统所有根目录
        File[] files1 = File.listRoots();
        for (File dir : files1) {
            System.out.println(dir);
        }
    }
}
