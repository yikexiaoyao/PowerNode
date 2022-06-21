package demo17;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ReceiveSocket {
    public static void main(String[] args) throws IOException {
        //创建Scanner对象
        Scanner scanner = new Scanner(System.in);
        //创建发送端点对象
        DatagramSocket ds = new DatagramSocket(8080);
        while (true) {
            //创建拆包对象
            byte[] buf = new byte[1024];
            int length = buf.length;
            DatagramPacket dp = new DatagramPacket(buf, length);
            //接收数据
            //阻塞方法
            ds.receive(dp);
            //获取拆包的真实数据
            byte[] data = dp.getData();
            int len = dp.getLength();
            //获取发送端的IP和端口号
            InetAddress address = dp.getAddress();
            String ip = address.getHostAddress();
            int port = dp.getPort();
            //将接收到的字节数据转换为字符串数据
            System.out.println(ip + ":" + port + "/" + new String(data, 0, len));
            ////////////////////给接收端回传数据，接收端要变为发送端////////////////////
            //准备回送的数据
            System.out.print("接收端: ");
            String send_data = scanner.nextLine();
            //创建封包对象
            byte[] bytes = send_data.getBytes();
            int send_len = bytes.length;
            DatagramPacket send_dp = new DatagramPacket(bytes, send_len, address, port);
            ds.send(send_dp);
        }
    }
}
