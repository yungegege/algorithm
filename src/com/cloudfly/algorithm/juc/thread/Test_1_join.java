package com.cloudfly.algorithm.juc.thread;

public class Test_1_join {

    public static void main(String[] args) throws Exception{
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(2);
            }
        });
        thread.start();
        thread.join();
        System.out.println(1);
    }
}
