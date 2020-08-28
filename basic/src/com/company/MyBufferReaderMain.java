package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class MyBufferReaderMain {

    public static void main(String [] args) throws IOException {

        FileReader fr = new FileReader("D:\\Code\\Java\\basic\\out\\production\\basic\\com\\company\\buf.txt");
        MyBufferReader bufr = new MyBufferReader(fr);
        String line = null;
        while ((line = bufr.myReadLine()) != null) {
            System.out.println(line);
        }
        bufr.myClose();

    }
}

class MyBufferReader extends Reader {

    private Reader r;

    private char [] buf = new char[1024];

    private int pos = 0; //当前操作数据的位置

    private int count = 0; //当前记录数据的个数

    MyBufferReader(Reader r) {
        this.r = r;
    }

    /*
    *读一个字符
    * */
    public int myRead() throws IOException {
        if(count == 0) {
            count = r.read(buf);
            pos = 0;
        }
        if(count < 0)
            return -1;
        char ch = buf[pos++];
        count--;
        return ch;
    }
    public String myReadLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        int ch = 0;
        while((ch = myRead()) != -1) {
            if(ch == '\r') {
                continue;
            }
            if(ch == '\n')
                return sb.toString();
            sb.append((char)ch);
        }
        if(sb.length() != 0)
            return sb.toString();
        return null;
    }
    public void myClose() throws IOException {
        r.close();
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return 0;
    }

    @Override
    public void close() throws IOException {

    }
}