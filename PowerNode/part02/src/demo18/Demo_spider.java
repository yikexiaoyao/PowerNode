package demo18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Demo_spider {
    public static void main(String[] args) throws IOException {
        //创建URL路径资源
        String path = "https://tieba.baidu.com/f?ie=utf-8&kw=clash%20for%20Windows&fr=search";
        URL url = new URL(path);
        System.out.println("url=" + url);
        //创建链接
        URLConnection conn = url.openConnection();
        //获取输入流对象
        InputStream in = conn.getInputStream();
        //创建字符输入缓冲流
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}
