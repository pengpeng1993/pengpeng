package com.company;

public class Ticket {

    public static void main(String[] args) {
        TicketDemo d1 = new TicketDemo();

        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d1);
        Thread t3 = new Thread(d1);
        Thread t4 = new Thread(d1);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}

class TicketDemo implements Runnable{
    private int num = 100;

    Object o = new Object();
    @Override
    public void run() {
        while(true) {
            synchronized (o) {
                if(num > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() +" num: " +num--);
                }
            }
        }
    }
}