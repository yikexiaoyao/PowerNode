package demo17;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketDemo {
    public static void main(String[] args) throws IOException {
        //创建客户端端点对象
        Socket socket = new Socket("192.168.137.110", 8080);
        //获取输出流对象
        OutputStream out = socket.getOutputStream();
        //给服务端写请求信息
        out.write("服务端你好，我是客户端".getBytes());
        //关闭客户端输出流
        socket.shutdownOutput();
        ////////////////////请求信息已发送成功，读取服务端响应信息////////////////////
        //获取输入流
        InputStream in = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = in.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        //关闭客户端
        socket.close();
    }
}
