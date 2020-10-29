package com.cloudfly.algorithm.juc.util;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;

public class Test_1_CountDownLatch {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                System.out.println("1跑起来了");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
                System.out.println("1跑完了");

            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                System.out.println("2跑起来了");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
                System.out.println("2跑完了");

            }
        };
        Thread thread3 = new Thread(){
            @Override
            public void run() {
                System.out.println("3跑起来了");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
                System.out.println("3跑完了");

            }
        };
        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println("等你们跑完。。。。。。。");
        countDownLatch.await();
        countDownLatch.await();
        System.out.println("俺跑了");
        System.out.println(thread1.getName());
        System.out.println(thread2.getName());
        System.out.println(thread3.getName());
        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return null;
            }
        });
        Thread thread = new Thread(task);
        thread.start();
        task.cancel(true);
    }
}
