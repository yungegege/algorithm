package com.cloudfly.algorithm.juc.util;

import java.util.concurrent.Semaphore;

public class Test_3_Semaphore {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(6);
        for (int i = 1; i <= 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + "开始执行");
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + "结束执行");
                        semaphore.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, "Thread-" + i).start();
        }
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(semaphore.availablePermits());
    }
}
