package demo17;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Demo {
    public static void main(String[] args) throws UnknownHostException {
        //获取IP对象
        InetAddress ip = InetAddress.getByName("192.168.137.110");
        System.out.println("IP=" + ip);
        //获取IP地址
        String hostAddress = ip.getHostAddress();
        System.out.println("hostAddress=" + hostAddress);
        //获取主机名
        String hostName = ip.getHostName();
        System.out.println("hostName=" + hostName);
        //获取服务器的所有IP
        InetAddress[] allByName = InetAddress.getAllByName("www.sina.com.cn");
        for (InetAddress inetAddress : allByName) {
            System.out.println(inetAddress);
        }
    }
}
