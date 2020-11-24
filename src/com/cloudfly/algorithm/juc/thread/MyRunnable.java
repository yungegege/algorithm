package com.cloudfly.algorithm.juc.thread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyRunnable implements Runnable {

    private RedeliveryConfig redeliveryConfig;
    private ScheduledExecutorService threadPoolExecutor;
    private int i;

    public MyRunnable(RedeliveryConfig redeliveryConfig, ScheduledExecutorService threadPoolExecutor, int i) {
        this.redeliveryConfig = redeliveryConfig;
        this.threadPoolExecutor = threadPoolExecutor;
        this.i = i;
    }

    @Override
    public void run() {
        // 重试次数加1
        redeliveryConfig.setCurrentCount(redeliveryConfig.getCurrentCount() + 1);
        // 如果大于最大重试次数，直接return
        if (redeliveryConfig.getCurrentCount() > redeliveryConfig.getMaximumRedelivery()) {
            return;
        }
        // 模拟执行定时任务
        printWithTime();
        // 计算下次任务执行时间
        long currentWaitTime = redeliveryConfig.getCurrentWaitTime();
        if (currentWaitTime == 0) {
            currentWaitTime = redeliveryConfig.getInitialRedeliveryDelay();
        }
        currentWaitTime *= redeliveryConfig.getBackOffMultiplier();
        redeliveryConfig.setCurrentWaitTime(currentWaitTime);
        // 把任务放入线程池
        threadPoolExecutor.schedule(this, currentWaitTime, TimeUnit.SECONDS);

    }

    public void printWithTime() {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSS: "))
                + " " + Thread.currentThread().getName() + " 执行定时任务" + i);
    }
}
