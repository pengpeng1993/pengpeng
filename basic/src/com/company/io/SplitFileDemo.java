package com.company.io;

import java.io.*;
import java.util.Properties;
import java.util.Vector;

public class SplitFileDemo {

    public static void main(String[] args)  throws IOException{

//        File file = new File("C:\\test\\1.pdf");
//        splitFile2(file);

        File file = new File("C:\\test");
        mergeFile2(file);
    }
    /*
    *对给定文件按指定大小进行切割
    **/
    private static final int SIZE = 1024 * 1024; //1M

    public static void splitFile(File file) throws IOException {
        FileInputStream inputStream = new FileInputStream(file);

        byte [] buf = new byte[SIZE];

        FileOutputStream outputStream = null;

        int len;//每次读取的字节数
        int count = 0;
        String filePath = "C:\\test";

        while((len = inputStream.read(buf)) != -1) {
            outputStream = new FileOutputStream(new File(filePath, count++ + ".part"));
            outputStream.write(buf,0,len);
            outputStream.close();
        }

        inputStream.close();
    }

    public static void splitFile2(File file) throws IOException {
        Properties pro = new Properties();
        FileInputStream inputStream1 = new FileInputStream(file);

        byte [] buf = new byte[SIZE];

        String filePath = "C:\\test";
        FileOutputStream outputStream1 = null;
        FileOutputStream outputStream2 = new FileOutputStream(new File(filePath,"split.properties"));

        int len;//每次读取的字节数
        int count = 0;

        while((len = inputStream1.read(buf)) != -1) {
            outputStream1 = new FileOutputStream(new File(filePath, count++ + ".part"));
            outputStream1.write(buf,0,len);
            outputStream1.close();
        }
        pro.setProperty("count",count + "");
        pro.store(outputStream2, "count");
        inputStream1.close();
        outputStream2.close();
    }

    public static void mergeFile1(File dir) throws IOException {

        Vector<InputStream> streams = new Vector<>();
        FileInputStream inputStream = null;
        for(int i = 0; i < 3; i++) {
            inputStream = new FileInputStream(new File(dir,i +".part"));
            streams.add(inputStream);
        }
        SequenceInputStream sequenceInputStream = new SequenceInputStream(streams.elements());

        FileOutputStream outputStream  = new FileOutputStream(new File(dir,"merge.pdf"));

        int len = 0 ;
        byte [] buf = new byte[SIZE];
        while((len = sequenceInputStream.read(buf)) != -1) {
            outputStream.write(buf,0,len);
        }
        sequenceInputStream.close();
        outputStream.close();
    }

    public static void mergeFile2(File dir) throws IOException {

        Properties pro = new Properties();
        FileInputStream inputStream = new FileInputStream(new File(dir,"split.properties"));
        pro.load(inputStream);

        int count = Integer.parseInt(pro.getProperty("count"));

        Vector<InputStream> streams = new Vector<>();
        FileInputStream inputStream1 = null;
        for(int i = 0; i < count; i++) {
            inputStream1 = new FileInputStream(new File(dir,i +".part"));
            streams.add(inputStream1);
        }
        SequenceInputStream sequenceInputStream = new SequenceInputStream(streams.elements());

        FileOutputStream outputStream  = new FileOutputStream(new File(dir,"merge.pdf"));

        int len = 0 ;
        byte [] buf = new byte[SIZE];
        while((len = sequenceInputStream.read(buf)) != -1) {
            outputStream.write(buf,0,len);
        }
        sequenceInputStream.close();
        outputStream.close();
    }
}
