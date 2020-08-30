package com.company.Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resource {
	private String name;
	private int count = 1;
	private boolean flag = false;

	Lock lock = new ReentrantLock();

	Condition producer_con = lock.newCondition();
	Condition consumer_con = lock.newCondition();

	public void set(String name) {
	    lock.lock();
	    try{
		while (flag) {
			try {
				producer_con.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.name = name + count;
		count++;
		System.out.println(Thread.currentThread().getName() + "---生产者---" + this.name);
		flag = true;
		consumer_con.signal();
	    } finally {
	        lock.unlock();
        }
	}
	public void out() {
	    lock.lock();
	    try {
		while (!flag) {
			try {
				consumer_con.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "---消费者---" + this.name);
		flag = false;
		producer_con.signal();
	    } finally {
	        lock.unlock();
        }
	}
}

class Producer implements Runnable {
	private Resource r;

	Producer(Resource r) {
		this.r = r;
	}

	@Override
	public void run() {
		while (true) {
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
		while (true) {
			r.out();
		}
	}
}

/**
 * ClassName ResourceDemo4 多个生产者和消费者出来,连续生产的问题,利用
 *
 * @Description todo
 * @Author pengpeng
 * @Date 2020/8/30 16:49 VERSION 1.0
 */

public class ResourceDemo5 {
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
