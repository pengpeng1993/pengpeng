/**package com.company.Lock;


class Resource {
    private String name;
    private int count = 1;
    private boolean flag = false;

    public synchronized void set(String name) {
        while(flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name + count;
        count++;
        System.out.println(Thread.currentThread().getName() + "---生产者---" + this.name);
        flag = true;
        notifyAll();
    }
    public synchronized void out() {
        while(!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() +"---消费者---"+this.name);
        flag = false;
        notifyAll();
    }
}

class Producer implements Runnable {
    private Resource r;

    Producer(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        while(true) {
            r.set("PENG");
        }
    }
}

class Consumer implements Runnable {
    private Resource r;
    Consumer(Resource r) {
        this.r = r;
    }
    @Override
    public void run() {
        while(true) {
            r.out();
        }
    }
}

/**
 * ClassName ResourceDemo4 多个生产者和消费者出来,连续生产的问题,利用
 *
 * @Description todo
 * @Author pengpeng
 * @Date 2020/8/30 16:49
 * VERSION 1.0

public class ResourceDemo4 {
    public static void main(String[] args) {
        Resource r = new Resource();

        Consumer c = new Consumer(r);
        Producer p = new Producer(r);

        Thread t0 = new Thread(c);
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(p);
        Thread t3 = new Thread(p);

        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }
}
 */
