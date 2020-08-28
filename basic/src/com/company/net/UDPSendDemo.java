package com.company.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSendDemo {
    public static void main(String[] args) throws IOException {
        //end1("hello你好!",InetAddress.getLocalHost(),8081);
        send2(InetAddress.getLocalHost(),8083);
    }
    public static void send1(String text, InetAddress address, int port) throws IOException {

        System.out.println("发送端启动......");
        /*
         * 创建UDP传输的发送端。
         * 思路：
         * 1，建立udp的socket服务。
         * 2，将要发送的数据封装到数据包中。
         * 3，通过udp的socket服务将数据包发送出去。
         * 4，关闭socket服务。
         */

        DatagramSocket datagramSocket = new DatagramSocket(8082);

        byte[] by = text.getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(by, by.length,address, port);
        datagramSocket.send(datagramPacket);

        datagramSocket.close();
    }
    public static void send2(InetAddress address, int port) throws IOException {

        System.out.println("发送端启动......");
        /*
         * 创建UDP传输的发送端。
         * 思路：
         * 1，建立udp的socket服务。
         * 2，将要发送的数据封装到数据包中。
         * 3，通过udp的socket服务将数据包发送出去。
         * 4，关闭socket服务。
         */

        DatagramSocket datagramSocket = new DatagramSocket(8082);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int len = -1;
        String text1;
        while((text1 = bufferedReader.readLine())!= null) {
            System.out.println(text1);
            if("886".equals(text1)) {
                break;
            }
            byte[] by = text1.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(by, by.length,address, port);
            datagramSocket.send(datagramPacket);

        }
        datagramSocket.close();
    }
}