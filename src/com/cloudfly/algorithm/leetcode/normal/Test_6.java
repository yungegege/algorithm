package com.cloudfly.algorithm.leetcode.normal;

import java.time.LocalDateTime;

public class Test_6 {

    public static void main(String[] args) {
        Test_6 test_6 = new Test_6();
        while (true) {
            test_6.acquire();
            System.out.println(LocalDateTime.now());
        }
    }


    // 当前令牌桶中的令牌数量
    long storedPermits = 0;
    // 令牌桶的容量
    long maxPermits = 2;
    // 上次发放时间
    long last = System.currentTimeMillis();
    // 发放令牌间隔：纳秒
    long interval = 10000_000L;

    /**
     * 获取令牌
     */
    public void acquire() {
        // 当前时间
        long curTime = System.currentTimeMillis();

        // 看看要等多久
        long waitTime = getPermit(curTime);

        if (waitTime > 0) {
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private synchronized long getPermit(long curTime) {
        // 间隔时间
        long time = curTime - last;
        if (time < interval && storedPermits == 0) {
            last += interval;
            return time;
        }
        // 当前令牌数量加上 上次发放至今生成的令牌
        storedPermits = Math.min(maxPermits, storedPermits + time / interval);
        storedPermits--;
        last += interval;
        return 0;
    }
}
