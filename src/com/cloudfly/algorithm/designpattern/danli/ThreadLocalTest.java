package com.cloudfly.algorithm.designpattern.danli;

public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
            @Override
            protected String initialValue() {
                return super.initialValue();
            }
        };
    }
}
