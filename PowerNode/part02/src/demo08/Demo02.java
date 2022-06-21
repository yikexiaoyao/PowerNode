package demo08;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;

public class Demo02 {
    private static int count;
    public static void getCount(File file) throws FileNotFoundException {
        if (file==null){
            throw new NullPointerException("文件对象不能为空");
        }
        if (!file.exists()) {
            throw new FileNotFoundException("文件不存在");
        }
        if(file.isFile()){
            throw new FileNotFoundException("不是目录");
        }
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory() || pathname.isFile() && pathname.getName().endsWith(".java");
            }
        });
        if(files!=null){
            for (File dir: files) {
                if (dir.isFile()){
                    count++;
                }else{
                    getCount(dir);
                }
            }
        }
    }
    public static void main(String[] args) {
        File[] files = File.listRoots();
        for (File file : files) {
            try {
                getCount(file);
            } catch (Exception e) {
                System.out.println("无法获取文件对象.....");
            }
        }
        System.out.println(".java文件夹的个数为：" + count);
    }
}
