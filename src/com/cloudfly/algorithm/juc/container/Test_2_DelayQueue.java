package com.cloudfly.algorithm.juc.container;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Test_2_DelayQueue {

    private static class MyDelayTask implements Delayed{


        private String name;
        private long time;

        private long start = System.currentTimeMillis();

        public MyDelayTask(String name, long time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(start+time-System.currentTimeMillis(),TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
        }

        @Override
        public String toString() {
            return "MyDelayTask{" +
                    "name='" + name + '\'' +
                    ", time=" + time +
                    ", start=" + start +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception{
        DelayQueue<MyDelayTask> delayQueue = new DelayQueue<>();
        delayQueue.add(new MyDelayTask("task-1",10000));
        delayQueue.add(new MyDelayTask("task-2",2000));
        delayQueue.add(new MyDelayTask("task-3",4000));
        delayQueue.add(new MyDelayTask("task-4",6000));
        delayQueue.add(new MyDelayTask("task-5",8000));

        while (true) {
            Delayed take = delayQueue.take();
            System.out.println(take);
        }
    }
}
