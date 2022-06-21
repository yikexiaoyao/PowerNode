package demo17;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class UpServerSocket {
    public static void main(String[] args) throws IOException {
        //创建服务端对象
        ServerSocket ss = new ServerSocket(9999);
        while (true) {
            //获取客户端对象
            Socket socket = ss.accept();
            new Thread(() -> {
                try {
                    //获取输入流，读取客户端上传的文件数据
                    InputStream in = socket.getInputStream();
                    byte[] bytes = new byte[1024];
                    int len = 0;
                    //获取客户端IP
                    String ip = socket.getInetAddress().getHostAddress();
                    //创建File类对象
                    File file = new File("c:\\Users\\DELL\\Desktop\\" + ip + ".jpg");
                    //定义计数器
                    int count = 1;
                    //判断文件是否存在
                    while (file.exists()) {
                        file = new File("c:\\Users\\DELL\\Desktop\\" + ip + "(" + count + ").jpg");
                        count++;
                    }
                    //创建字节输出流，写出读取到的上传文件数据
                    FileOutputStream fos = new FileOutputStream(file);
                    while ((len = in.read(bytes)) != -1) {
                        fos.write(bytes, 0, len);
                    }
                    //获取输出流，给客户端写响应信息
                    socket.getOutputStream().write("文件上传成功".getBytes());
                    //关闭客户端
                    socket.close();
                } catch (IOException e) {
                    System.out.println("上传失败");
                }
            }).start();
        }
    }
}
