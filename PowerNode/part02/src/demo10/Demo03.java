package demo10;

import java.io.FileInputStream;
import java.io.IOException;

public class Demo03 {
    public static void main(String[] args) throws IOException {
        try {
            //创建输入输出流对象
            FileInputStream fis = new FileInputStream("c:\\Users\\DELL\\Desktop\\1.txt");
            int count = 0;
            int a;
            while ((a = fis.read()) != -1) {
                if((a>'a'&&a<'z') || (a>'A'&&a<'Z')){
                    count++;
                }
            }
            System.out.println("字谜字符出现的次数是：" + count);
            //关闭流
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
