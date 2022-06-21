package demo10;

import java.io.*;

public class Demo05 {
    static FileWriter fw = null;

    public static void printFileTree(File file, int level) throws IOException {
        if (file == null) {
            throw new NullPointerException();
        }
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        if (file.isFile()) {
            throw new FileNotFoundException();
        }
        String a = "";
        for (int i = 0; i < level; i++) {
            a += "	";
        }
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() || pathname.isDirectory();
            }
        });
        //判断非空
        if (files != null) {
            //遍历
            for (File dir : files) {
                fw.write(a + dir.getAbsolutePath() + System.lineSeparator());
                //判断是否为目录
                if (dir.isDirectory()) {
                    printFileTree(dir, level + 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try {
            //创建file对象
            File file = new File("e:\\");
            //创建file对象
            fw = new FileWriter("c:\\Users\\DELL\\Desktop\\1.txt");
            //创建字符输出流对象
            fw.write(file.getPath() + System.lineSeparator());
            //调用自定义方法
            printFileTree(file, 1);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
