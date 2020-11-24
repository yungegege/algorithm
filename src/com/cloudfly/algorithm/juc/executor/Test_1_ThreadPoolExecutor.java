package com.cloudfly.algorithm.juc.executor;

import java.util.List;
import java.util.concurrent.*;

public class Test_1_ThreadPoolExecutor {
    public static void main(String[] args) throws Exception {
        /**
         * public ThreadPoolExecutor(int corePoolSize,
         *                               int maximumPoolSize,
         *                               long keepAliveTime,
         *                               TimeUnit unit,
         *                               BlockingQueue<Runnable> workQueue,
         *                               ThreadFactory threadFactory,
         *                               RejectedExecutionHandler handler)
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        // 提前创建并启动核心线程
        threadPoolExecutor.prestartAllCoreThreads();
        // 提交任务,无返回值
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                // TODO
            }
        });
        // 提交任务，有返回值
        Future<Object> future = threadPoolExecutor.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        });
        Object object = future.get();
        future.cancel(true);
        // 关闭线程池,把线程池状态设为SHUTDOWN状态，然后中断所有没在执行任务的的线程
        threadPoolExecutor.shutdown();
        // 关闭线程池,把线程池状态设为STOP状态状态，然后停止所有正在执行或者暂停的线程，并返回等待执行任务的列表
        List<Runnable> list = threadPoolExecutor.shutdownNow();
    }
}
