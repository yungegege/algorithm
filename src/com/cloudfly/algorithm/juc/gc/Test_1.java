package com.cloudfly.algorithm.juc.gc;

import java.util.ArrayList;
import java.util.List;

public class Test_1 {

    public static void main(String[] args) throws Exception {
        test1();
//        test2();

    }

    /**
     * -Xms20m -Xmx20m -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+HeapDumpOnOutOfMemoryError -Xloggc:gc.log
     * @throws Exception
     */
    private static void test1() throws Exception {
        List<Test_1> list = new ArrayList<>();
        while (true) {
            list.add(new Test_1());
        }
    }

    private static void test2() {
        //        String a = new String("aaa");
//        String b = new String("aaa");
//        String c = a.intern();
//        String d = "aaa";
//        System.out.println(a==b);
//        System.out.println(a==c);
//        System.out.println(b==c);
//        System.out.println(a==d);
//        System.out.println(b==d);
//        System.out.println(c==d);

    }
}
