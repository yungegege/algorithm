package com.cloudfly.algorithm.juc.thread;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test_3_ScheduledThreadPoolExecutor {

    public static void main(String[] args) {
        ScheduledExecutorService threadPoolExecutor = new ScheduledThreadPoolExecutor(1);

        for (int i = 0; i < 2; i++) {
            RedeliveryConfig redeliveryConfig = new RedeliveryConfig();
            redeliveryConfig.setMaximumRedelivery(5);
            redeliveryConfig.setBackOffMultiplier(2);
            redeliveryConfig.setInitialRedeliveryDelay(2);
            redeliveryConfig.setUseMultipleBackOff(true);
            threadPoolExecutor.schedule(new MyRunnable(redeliveryConfig, threadPoolExecutor, i),
                    redeliveryConfig.getInitialRedeliveryDelay(), TimeUnit.SECONDS);
        }
    }


}
