package demo07;

import java.io.File;
import java.io.IOException;

public class Demo_create_delete {
    public static void main(String[] args) throws IOException {
        //创建文件对象
        File file = new File("c:\\Users\\DELL\\Desktop\\test");
        //创建目录
        boolean mkdir = file.mkdirs();
        System.out.println("mkdir=" + mkdir);
        //创建文件
        boolean newFile = file.createNewFile();
        System.out.println("newFile=" + newFile);
        //删除
        boolean delete = file.delete();
        System.out.println("delete=" + delete);
    }
}
