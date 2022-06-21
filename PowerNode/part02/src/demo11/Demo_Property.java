package demo11;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Demo_Property {
    public static void main(String[] args) throws IOException {
        //创建属性集对象
        Properties prop= new Properties();
        //将文件中的数据读取到集合中
        prop.load(new FileReader("c:\\Users\\DELL\\Desktop\\1.txt"));
        //遍历集合
        for (String key : prop.stringPropertyNames()) {
            //通过key获取value
            String value=prop.getProperty(key);
            System.out.println(key+"="+value);
        }
    }
}
