package com.cloudfly.algorithm.jvm.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * -XX:+PrintGCDetails
 * -XX:+PrintGCDateStamps
 * -XX:+HeapDumpOnOutOfMemoryError
 * -Xloggc:gc.log
 * -XX:PrintHeapAtGC:打印GC前后的详细堆栈信息
 */
public class Test_1_gc {

    public static void main(String[] args) {
        List<Test_1_gc> list = new ArrayList<>();
        while (true){
//            list.add(new Test_1_gc());
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
