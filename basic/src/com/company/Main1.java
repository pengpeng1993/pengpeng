package com.company;

public class Main1 {
    public static void main(String[] args) {
        Resource r = new Resource();

        Input in = new Input(r);
        Output out = new Output(r);

        Thread t1 = new Thread(in);
        Thread t2 = new Thread(out);

        t1.start();
        t2.start();
    }
}

class Resource
{
    private String name;
    private String sex;
    private boolean flag = false; //资源是否有值

    public synchronized void set(String name, String sex) {
        if(flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name;
        this.sex = sex;
        flag = true;
        this.notify();
    }
    public synchronized void out() {
        if(!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + ".........." + sex);
        flag = false;
        this.notify();
    }
}

class Output implements Runnable
{
    Output( Resource r)
    {
        this.r = r;
    }
    Resource r;
    @Override
    public void run() {
        int x = 0;
        while(true) {
            r.out();
        }
    }
}

class Input implements Runnable
{
    Input( Resource r)
    {
        this.r = r;
    }
    Resource r;
    @Override
    public void run() {
        int x = 0;
        while (true) {

            if (x == 0) {
                r.set("mike", "M");
            } else {
                r.set("丽丽", "女");
            }
            x = (x + 1) % 2;
        }
    }
}