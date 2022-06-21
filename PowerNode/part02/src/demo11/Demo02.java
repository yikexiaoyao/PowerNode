package demo11;

import java.io.*;
import java.util.TreeMap;

public class Demo02 {
    public static void main(String[] args) throws IOException {
        //创建转换流对象
        InputStreamReader isr = new InputStreamReader(
                new FileInputStream("c:\\Users\\DELL\\Desktop\\1.txt")
        );
        //创建字符输入输出缓冲流
        BufferedReader br = new BufferedReader(isr);
        BufferedWriter bw = new BufferedWriter(new FileWriter("c:\\Users\\DELL\\Desktop\\2.txt"));
        //创建map集合对象
        TreeMap<String, String> map = new TreeMap<>();
        //读取
        String line = null;
        while((line=br.readLine()) != null){
            System.out.println(line);
            String[] split = line.split("\\.");
            map.put(split[0], split[1]);
        }
        //遍历集合
        for(String key:map.keySet()){
            //获取value
            String value = map.get(key);
            bw.write(key+"." +value);
            //换行
            bw.newLine();
        }
        //关闭流
        bw.close();
        br.close();
        isr.close();
    }
}
