package demo07;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo_boolean {
    public static void main(String[] args) throws FileNotFoundException {
        //创建文件对象
        File file = new File("abc.txt");
        //判断文件是否存在
        boolean exists = file.exists();
        //存在
        if (exists) {
            //判断文件对象是否为普通文件
            if (file.isFile()) {
                //获取最后一次修改时间
                long time = file.lastModified();
                System.out.println("time=" + time);
                Date date = new Date(time);
                System.out.println("date=" + date);
                //格式化
                String format = new SimpleDateFormat("yyyy年MM月dd日, HH:mm:ss").format(date);
                System.out.println("format=" + format);
            } else {
                System.out.println("目录...");
            }
            //判断文件是否为隐藏文件
            System.out.println("是隐藏文件吗？" + file.isHidden());
            //判断是否为绝对路径
            System.out.println("是绝对路径吗？" + file.isAbsolute());
        } else {
            //不存在
            throw new FileNotFoundException("文件不存在！");
        }
    }
}
