package demo09;

import java.io.FileOutputStream;
import java.io.IOException;

public class Demo_append_line {
    public static void main(String[] args) throws IOException {
        //创建对象
        FileOutputStream fos = new FileOutputStream("c:\\Users\\DELL\\Desktop\\1.txt", true);
        //获取系统换行符
        String line = System.lineSeparator();
        fos.write(("床前明月光" + line).getBytes());
        fos.write(("疑是地上霜" + line).getBytes());
        fos.write(("举头望明月" + line).getBytes());
        fos.write(("低头思故乡" + line).getBytes());
        //释放资源
        fos.close();
    }
}
