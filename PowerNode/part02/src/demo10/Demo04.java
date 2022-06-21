package demo10;

import java.io.FileWriter;
import java.io.IOException;

public class Demo04 {
    public static void main(String[] args) throws IOException {
        try {
            //创建输出流对象
            FileWriter fw = new FileWriter("c:\\Users\\DELL\\Desktop\\1.txt");
            //行
            for (int m = 1; m <= 9; m++) {
                //列
                for (int n = 1; n <= m; n++) {
                    //空一个TAB位置
                    fw.write(n + "*" + m + "=" + m * n + "\t");
                }
                //换行
                fw.write(System.lineSeparator());
            }
            //关闭流
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
