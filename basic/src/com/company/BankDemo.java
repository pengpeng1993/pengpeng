package com.company;

public class BankDemo {
    public static void main(String[] args) {
        Cus s = new Cus();
        Thread t2 = new Thread(s);
        Thread t1= new Thread(s);
        t1.start();
        t2.start();
    }
}
class Cus implements Runnable {

    private Bank b = new Bank();
    @Override
    public void run() {
        for(int x=0; x<3; x++)
        {
            b.add(100);
        }
    }
}

class Bank {
    int sum = 0;
    public synchronized  void add(int num) {
        sum += num;
        System.out.println("sum="+sum);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
