package com.cloudfly.algorithm.juc.thread;

import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Test_1_join {

    public static void main(String[] args) throws Exception {
        HashMap<String,String> map = new HashMap<>();
        map.put("1","1");
        map.put("1","2");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(2);
            }
        });
        thread.start();
        thread.join();
        System.out.println(1);
        Thread thread2 = new Thread(new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return null;
            }
        }));

    }
}
