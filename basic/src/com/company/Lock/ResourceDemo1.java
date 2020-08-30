/**
package com.company.Lock;

/**
 * ClassName ResourceDemo1
 *
 * @Description 一个资源位,一取一拿,利用同步解决拿不对的问题
 * @Author pengpeng
 * @Date 2020/8/30 0:19
 * VERSION 1.0


class Resource {
    String name;
    String sex;
}

class Input implements Runnable {
    private Resource r;

    Input(Resource r) {
        this.r = r;
    }
    int x= 0;
    @Override
    public void run() {
        while(true) {
            synchronized (r) {
                if(x % 2 == 0) {
                    r.name = "peng";
                    r.sex = "M";
                } else {
                    r.name = "chen";
                    r.sex = "F";
                }
            }
            x++;
        }

    }
}
class Output implements Runnable {
    private Resource r;

    Output(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (r) {
                System.out.println("name: " + r.name + " sex: " + r.sex);
            }
        }
    }
}
public class ResourceDemo1 {

    public static void main(String[] args) {
        Resource r = new Resource();
        Input input = new Input(r);
        Output output = new Output(r);

        Thread t1 = new Thread(input);
        Thread t2 = new Thread(output);

        t1.start();
        t2.start();
    }
}
*/