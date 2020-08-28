package com.company.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceDemo {

    public static void main(String[] args) throws IOException {
        //rece1(8081);
        rece2(8083);
    }
    public static  void rece1(int port) throws IOException {

        System.out.println("接收端启动......");
        /*
         * 建立UDP接收端的思路。
         * 1，建立udp socket服务,因为是要接收数据，必须要明确一个端口号。
         * 2，创建数据包，用于存储接收到的数据。方便用数据包对象的方法解析这些数据.
         * 3，使用socket服务的receive方法将接收的数据存储到数据包中。
         * 4，通过数据包的方法解析数据包中的数据。
         * 5，关闭资源
         */

        DatagramSocket datagramSocket = new DatagramSocket(port);
        byte [] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);
        datagramSocket.receive(datagramPacket);

        String ip = datagramPacket.getAddress().getHostAddress();
        int portFrom = datagramPacket.getPort();
        String text = new String(datagramPacket.getData());
        System.out.println(ip+":"+portFrom+":"+text);

        datagramSocket.close();
    }
    public static  void rece2(int port) throws IOException {

        System.out.println("接收端启动......");
        DatagramSocket datagramSocket = new DatagramSocket(port);
        while(true) {
            byte [] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);
            datagramSocket.receive(datagramPacket);

            String ip = datagramPacket.getAddress().getHostAddress();
            int portFrom = datagramPacket.getPort();
            String text = new String(datagramPacket.getData());
            System.out.println(ip+":"+portFrom+":"+text);
        }
    }
}
