package com.cloudfly.algorithm.juc.automic;

import java.util.concurrent.atomic.*;

public class Test_1_Atomic {

    public volatile Integer a = 1;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        AtomicIntegerArray array = new AtomicIntegerArray(arr);
        array.addAndGet(0, 2);
        System.out.println(array.get(0));

        AtomicReferenceFieldUpdater<Test_1_Atomic, Integer> updater =
                AtomicReferenceFieldUpdater.newUpdater(Test_1_Atomic.class, Integer.class, "a");
        Test_1_Atomic atomic = new Test_1_Atomic();
        updater.getAndSet(atomic,2);
        System.out.println(updater.get(atomic));
    }
}
