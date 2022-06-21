package demo17;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class UpSocket {
    public static void main(String[] args) throws IOException {
        //创建客户端对象
        Socket socket = new Socket("192.168.137.110", 9999);
        //创建文件字节输入流，读取需要上传的文件数据
        FileInputStream fis = new FileInputStream("c:\\Users\\DELL\\Desktop\\1.jpg");
        byte[] bytes = new byte[1024];
        int len = 0;
        //获取输出流对象，将读取到需要上传的数据写进连接通道中
        OutputStream out = socket.getOutputStream();
        while ((len = fis.read(bytes))!=-1){
            out.write(bytes,0,len);
        }
        //关闭客户端输出流
        socket.shutdownOutput();
        //获取输入流对象，读取服务端的响应信息
        InputStream in = socket.getInputStream();
        byte[] buff = new byte[1024];
        int length = in.read(buff);
        System.out.println(new String(buff,0,length));
        //关闭客户端
        socket.close();
    }
}
