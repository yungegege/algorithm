package com.cloudfly.algorithm.juc.thread;

public class Test_2_threadLocal {

    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("aaa");
        threadLocal.get();
        threadLocal.remove();
        Thread thread = new Thread();
        // 检查是否被中断，清除中断标志
        boolean b1 = Thread.interrupted();
        // 检查是否被中断
        boolean b2 = thread.isInterrupted();
        // 中断线程
        thread.interrupt();
    }
}
