package demo09;

import java.io.*;

public class FileOutputStream_Test {
    //创建字符输出流对象
    static FileOutputStream fos;

    static {
        try {
            fos = new FileOutputStream("c:\\Users\\DELL\\Desktop\\1.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void print(File file) throws IOException {
        if (file == null) {
            throw new NullPointerException("文件对象不能为空");
        }
        if (!file.exists()) {
            throw new FileNotFoundException("文件不存在");
        }
        if (file.isFile()) {
            throw new FileNotFoundException("不是目录");
        }
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory() || pathname.isFile() && pathname.getName().endsWith(".java");
            }
        });
        String line = System.lineSeparator();
        //判断非空
        if (files != null) {
            //遍历
            for (File dir : files) {
                if (dir.isFile()) {
                    //获取绝对路径
                    String path = dir.getAbsolutePath();
                    fos.write((path + line).getBytes());
                } else {
                    print(dir);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //列举盘符
        /*File[] files = File.listRoots();
        for (File file : files) {
            print(file);
        }*/
        File file = new File("c:\\");
        print(file);
        //释放资源
        fos.close();
    }
}
