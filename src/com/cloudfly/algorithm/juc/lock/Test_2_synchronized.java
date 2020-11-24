package com.cloudfly.algorithm.juc.lock;

public class Test_2_synchronized {

    public static void main(String[] args) {
        Object object = new Object();
        int[] arr = new int[1];
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1执行");
                synchronized (object) {
                    try {
                        System.out.println("1进入同步代码块");
                        object.wait();
                        System.out.println("1被唤醒");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("1退出同步代码块");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("2执行");
                synchronized (object) {
                    System.out.println("2进入同步代码块");
                    object.notify();
                    System.out.println("2唤醒1");
                }
                System.out.println("2退出同步代码块");
            }
        }).start();
    }
}
