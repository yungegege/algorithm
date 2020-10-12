package com.cloudfly.algorithm.juc.container;

import java.util.concurrent.ConcurrentHashMap;

public class Test_1_ConcurrentHashMap {

    public static void main(String[] args) {
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("a","1");
    }
}
