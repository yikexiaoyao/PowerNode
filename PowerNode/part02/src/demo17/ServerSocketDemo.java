package demo17;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {
    public static void main(String[] args) throws IOException {
        //创建服务端端点对象
        ServerSocket ss = new ServerSocket(8080);
        //获取客户端对象
        Socket socket = ss.accept();
        //通过客户端获取输入流对象
        InputStream in = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = in.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        ////////////////////读取完客户端的请求信息，写出相应信息////////////////////
        socket.getOutputStream().write("已收到请求信息".getBytes());
        //关闭客户端对象
        socket.close();
    }
}
