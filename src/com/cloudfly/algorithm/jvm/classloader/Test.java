package com.cloudfly.algorithm.jvm.classloader;

public class Test {
    String aaa;
    static {
        System.out.println(1);
    }

    public static void main(String[] args) {
        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
