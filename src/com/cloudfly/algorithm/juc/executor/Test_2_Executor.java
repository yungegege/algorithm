package com.cloudfly.algorithm.juc.executor;

import java.util.concurrent.*;

public class Test_2_Executor {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Executors.newFixedThreadPool(2);
        Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(1);
        Executors.newSingleThreadScheduledExecutor();
        Future<Integer> f = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(2000);
                System.out.println(1);
                return 1;
            }
        });
        boolean cancel = f.cancel(false);
        System.out.println("end");



    }
}
