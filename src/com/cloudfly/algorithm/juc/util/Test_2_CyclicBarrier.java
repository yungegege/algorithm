package com.cloudfly.algorithm.juc.util;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Test_2_CyclicBarrier {

    public static void main(String[] args) {
        int num = 5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 是最后到的线程，要执行我");
            }
        });
        for (int i = 0; i < num; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + " 到达栅栏 A");
                        cyclicBarrier.await();
                        System.out.println(Thread.currentThread().getName() + " 冲破栅栏 A");

                        Thread.sleep(2000);
                        System.out.println(Thread.currentThread().getName() + " 到达栅栏 B");
                        cyclicBarrier.await();
                        System.out.println(Thread.currentThread().getName() + " 冲破栅栏 B");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }


        System.out.println(test1());

    }

    private static int test1() {
        int a = 1;
        try {
            a = 2;
            return a;
        } catch (Exception e) {
            a = 3;
            return a;
        } finally {
            a = 4;
        }
    }
}
