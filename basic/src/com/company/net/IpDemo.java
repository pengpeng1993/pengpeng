package com.company.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class IpDemo {
    public static void main(String[] args) throws IOException {
//        InetAddress add = InetAddress.getLocalHost();
//        System.out.println(add.getHostName());
//        System.out.println(add.getHostAddress());
        DatagramSocket send = new DatagramSocket();

        DatagramSocket rece = new DatagramSocket(8083);
        new Thread(new Send(send)).start();
        new Thread(new Rece(rece)).start();
    }
}

class Send implements Runnable {
    private DatagramSocket datagramSocket = null;
    public Send(DatagramSocket datagramSocket) {
        this.datagramSocket = datagramSocket;
    }
    @Override
    public void run() {
        while(true) {
            byte [] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);
            try {
                this.datagramSocket.receive(datagramPacket);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String ip = datagramPacket.getAddress().getHostAddress();
            int portFrom = datagramPacket.getPort();
            String text = new String(datagramPacket.getData());
            System.out.println(ip+":"+portFrom+":"+text);
        }
    }
}

class Rece implements Runnable {
    private DatagramSocket datagramSocket = null;
    public Rece(DatagramSocket datagramSocket) {
        this.datagramSocket = datagramSocket;
    }
    @Override
    public void run() {
        /*
         * 创建UDP传输的发送端。
         * 思路：
         * 1，建立udp的socket服务。
         * 2，将要发送的数据封装到数据包中。
         * 3，通过udp的socket服务将数据包发送出去。
         * 4，关闭socket服务。
         */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int len = -1;
        String text1;
        while(true) {
            try {
                if (((text1 = bufferedReader.readLine()) == null)) {
                    break;
                }

                if("886".equals(text1)) {
                    break;
                }
                byte[] by = text1.getBytes();
                DatagramPacket datagramPacket = new DatagramPacket(by, by.length, InetAddress.getLocalHost(),8083);
                datagramSocket.send(datagramPacket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        datagramSocket.close();
    }
}