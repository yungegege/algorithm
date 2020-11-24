package com.cloudfly.algorithm.jvm.stack;

public class Test_1_dongtailianjie {

    private int num;

    public void methodA(int a){
        int aaa = 1;
        System.out.println("methodA()--------");
    }

    public void methodB(int b){
        System.out.println("methodB()--------");
        methodA(1);
        num++;
    }
}
