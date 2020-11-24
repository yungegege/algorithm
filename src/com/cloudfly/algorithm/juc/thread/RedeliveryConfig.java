package com.cloudfly.algorithm.juc.thread;


/**
 * 重发配置
 *
 * @author jifengzhu
 * @create 2019-12-19 14:27
 **/
public class RedeliveryConfig {

    /**
     * 最大重发次数
     */
    private int maximumRedelivery;
    /**
     * 重发时间间隔（毫秒单位）
     */
    private long initialRedeliveryDelay;
    /**
     * 重发时间间隔是否随重发次数增加<br>
     *     如：重发时间间隔设置为10秒，重发间隔时间倍数据为2，第一次重发间隔为10秒，则第二次重发间隔为40秒，计算公式为当时重发次数*重发间隔时间倍数*重发时间间隔
     */
    private boolean useMultipleBackOff;
    /**
     * 重发间隔时间倍数
     */
    private int backOffMultiplier;

    /**
     * 当前重发次数
     * @return
     */
    private int currentCount;

    /**
     * 当前要等的时间
     * @return
     */
    private long currentWaitTime;

    public long getCurrentWaitTime() {
        return currentWaitTime;
    }

    public void setCurrentWaitTime(long currentWaitTime) {
        this.currentWaitTime = currentWaitTime;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public int getMaximumRedelivery() {
        return maximumRedelivery;
    }

    public void setMaximumRedelivery(int maximumRedelivery) {
        this.maximumRedelivery = maximumRedelivery;
    }

    public long getInitialRedeliveryDelay() {
        return initialRedeliveryDelay;
    }

    public void setInitialRedeliveryDelay(long initialRedeliveryDelay) {
        this.initialRedeliveryDelay = initialRedeliveryDelay;
    }

    public boolean isUseMultipleBackOff() {
        return useMultipleBackOff;
    }

    public void setUseMultipleBackOff(boolean useMultipleBackOff) {
        this.useMultipleBackOff = useMultipleBackOff;
    }

    public int getBackOffMultiplier() {
        return backOffMultiplier;
    }

    public void setBackOffMultiplier(int backOffMultiplier) {
        this.backOffMultiplier = backOffMultiplier;
    }
}
