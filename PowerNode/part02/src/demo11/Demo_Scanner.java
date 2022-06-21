package demo11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Demo_Scanner {
    public static void read() throws IOException {
        //获取系统输入流，读取键盘输入数据
        InputStream in = System.in;
        int a = 0;
        while ((a = in.read()) != -1) {
            if (a == '0') {
                break;
            }
            System.out.println((char) a);
        }
    }

    public static void main(String[] args) throws IOException {
        //获取系统输入流，读取键盘输入数据
        InputStream in = System.in;
        //将获取到的字节流转换为字符流
        InputStreamReader isr = new InputStreamReader(in);
        //字符输入缓冲流
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        while ((line = br.readLine()) != null) {
            if (line.equals("over")) {
                break;
            }
            System.out.println(line);
        }
        br.close();
        isr.close();
    }
}
