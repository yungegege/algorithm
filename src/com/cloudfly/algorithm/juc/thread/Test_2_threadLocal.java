package com.cloudfly.algorithm.juc.thread;

public class Test_2_threadLocal {

    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("aaa");
        threadLocal.get();
        threadLocal.remove();
    }
}
