/*package com.company;

public class ProducerConsumerDemo {
    public static void main(String [] args) {
        Resource1 r = new Resource1();

        Producer pro = new Producer(r);
        Consumer con = new Consumer(r);

        Thread t0 = new Thread(pro);
        Thread t1 = new Thread(pro);
        Thread t2 = new Thread(con);
        Thread t3 = new Thread(con);

        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }
}

class Resource1 {
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
        System.out.println(Thread.currentThread().getName() + "生产者" + this.name);
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
        System.out.println(Thread.currentThread().getName() + "消费者" + this.name);
        flag = false;
        notifyAll();
    }
}

class Producer implements Runnable {
    Producer(Resource1 r) {
        this.r = r;
    }
    private Resource1 r;
    @Override
    public void run() {
        while(true) {
            r.set("肯德基");
        }
    }
}

class Consumer implements Runnable {
    Consumer(Resource1 r) {
        this.r = r;
    }
    private Resource1 r;
    @Override
    public void run() {
        while(true) {
            r.out();
        }
    }
}
*
 */
package com.company;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerDemo {
    public static void main(String [] args) {
        Resource1 r = new Resource1();

        Producer pro = new Producer(r);
        Consumer con = new Consumer(r);

        Thread t0 = new Thread(pro);
        Thread t1 = new Thread(pro);
        Thread t2 = new Thread(con);
        Thread t3 = new Thread(con);

        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }
}

class Resource1 {
    private String name;
    private int count = 1;
    private boolean flag = false;

    Lock lock = new ReentrantLock();
    Condition producer_con = lock.newCondition();
    Condition consumer_con = lock.newCondition();

    public void set(String name) {
        lock.lock();
        try {
            while(flag) {
                try {
                    producer_con.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.name = name + count;
            count++;
            System.out.println(Thread.currentThread().getName() + "生产者" + this.name);
            flag = true;
            consumer_con.signal();
        } finally {
            lock.unlock();
        }

    }

    public void out() {
        lock.lock();
        try {
            while(!flag) {
                try {
                    consumer_con.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "消费者" + this.name);
            flag = false;
           producer_con.signal();
        } finally {
            lock.unlock();
        }

    }
}

class Producer implements Runnable {
    Producer(Resource1 r) {
        this.r = r;
    }
    private Resource1 r;
    @Override
    public void run() {
        while(true) {
            r.set("肯德基");
        }
    }
}

class Consumer implements Runnable {
    Consumer(Resource1 r) {
        this.r = r;
    }
    private Resource1 r;
    @Override
    public void run() {
        while(true) {
            r.out();
        }
    }
}