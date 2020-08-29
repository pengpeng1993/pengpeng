package com.company.Single;

public class Single {
    public static void main(String args[]) {
        SingleDemo s = SingleDemo.getInstance();
        SingleDemo2 s2 = SingleDemo2.getInstance();
    }
}

/**
 * 1私有化构造函数
 * 2提供公有化获取实例的方法
 * */
class SingleDemo {

    private  SingleDemo(){}
    private static SingleDemo s = new SingleDemo();
    public static SingleDemo getInstance() {
        return s;
    }
}
/**
 * todo 安全问题
 * */
class SingleDemo2 {
    private  SingleDemo2(){}
    private static SingleDemo2 s = null;
    public static SingleDemo2 getInstance() {
        if(s == null) {
            s = new SingleDemo2();
        }
        return s;
    }
}
