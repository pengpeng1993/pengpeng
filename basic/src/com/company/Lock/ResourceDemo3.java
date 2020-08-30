/**package com.company.Lock;

/**
 * ClassName ResourceDemo2
 *
 * @Description 一个资源位,一取一放,利用同步解决取不对的问题,解决完取不对的问题,希望一放一取,利用锁对象的wait与notify解决
 *              1，wait(): 让线程处于冻结状态，被wait的线程会被存储到线程池中。
 *              2，notify():唤醒线程池中一个线程(任意). 3，notifyAll():唤醒线程池中的所有线程。
 *              这里将同步放到了资源的类中
 * @Author pengpeng
 * @Date 2020/8/31 0:19 VERSION 1.0


class Resource {

	private String name;
	private String sex;
	Boolean flag = false; // 标记是否存在资源


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
		this.flag = true;
		notify();
	}
	public synchronized void get() {
	    if(!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("name: " + name + " sex: " + sex);
        this.flag = false;
        notify();
	}
}

class Input implements Runnable {
	private Resource r;

	Input(Resource r) {
		this.r = r;
	}
	int x = 0;
	@Override
	public void run() {
        while (true) {
            if (x % 2 == 0) {
                r.set("Peng","M");
            } else {
                r.set("Chen","F");
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
		while (true) {
			r.get();
		}
	}
}
public class ResourceDemo3 {

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
