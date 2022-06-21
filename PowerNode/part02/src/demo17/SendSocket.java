package demo17;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class SendSocket {
    public static void main(String[] args) throws IOException {
        //创建Scanner对象
        Scanner scanner = new Scanner(System.in);
        //创建发送端端点对象，如果不指定端口，JVM会分配随机端口号
        DatagramSocket ds = new DatagramSocket();
        while (true) {
            //准备数据
            System.out.println("发送端：");
            String data = scanner.nextLine();
            //创建封装对象
            byte[] buf = data.getBytes();
            int length = buf.length;
            InetAddress address = InetAddress.getByName("DESKTOP-CTY");
            int port = 8080;
            DatagramPacket dp = new DatagramPacket(buf, length, address, port);
            ds.send(dp);
            ////////////////////发送结束后，接收回传数据，发送端变接收端////////////////////
            //创建拆包对象
            byte[] bytes = new byte[1024];
            int len = bytes.length;
            DatagramPacket receive_dp = new DatagramPacket(bytes, len);
            ds.receive(receive_dp);
            //获取真实数据和长度
            byte[] buff = receive_dp.getData();
            int length1 = receive_dp.getLength();
            System.out.println(new String(buff, 0, length1));
        }
    }
}
