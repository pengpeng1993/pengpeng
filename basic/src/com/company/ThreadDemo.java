package com.company;

public class ThreadDemo {

    public static void main(String[] args) {
        Demo d1 = new Demo();
        Demo d2 = new Demo();
        d1.start();
        d2.start();

        Demo2 d3 = new Demo2();
        Thread t3 = new Thread(d3);
        Thread t4 = new Thread(d3);

        t3.start();
        t4.start();
        Demo4 d4 = new Demo4();
        Thread t5 = new Thread(d4);
        Thread t6 = new Thread(d4);
        t5.start();
        t6.start();
    }
}


class Demo extends Thread {
    @Override
    public void run() {
        System.out.println("test"+Thread.currentThread().getName());
    }
}

class Demo2 implements Runnable{
    @Override
    public void run() {
        System.out.println("test"+Thread.currentThread().getName());
    }
}

class Demo3 {
    private Runnable r;
    Demo3() {

    }
    Demo3(Runnable r) {
        this.r = r;
    }
    public void run() {
        if(r != null) {
            r.run();
        }
    }
    public void start() {
        run();
    }
}

class Demo4 implements Runnable{
    @Override
    public void run() {
        show();
    }
    private void show() {
        for(int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "i:" + i);
        }
    }
}