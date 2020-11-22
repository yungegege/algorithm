package com.cloudfly.algorithm.juc.container;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test_1_ConcurrentHashMap {

    public static void main(String[] args) {
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>(32);
        Map<String,String> hashMap = new HashMap<>(32);
        concurrentHashMap.put("a","1");
        String a = concurrentHashMap.get("a");
        concurrentHashMap.size();

    }
}
