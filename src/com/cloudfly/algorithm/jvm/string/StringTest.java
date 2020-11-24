package com.cloudfly.algorithm.jvm.string;

public class StringTest implements Cloneable{

    int a = 1;
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws Exception{
        StringTest stringTest = new StringTest();
        StringTest clone = (StringTest)stringTest.clone();
        System.out.println(stringTest.a);
        System.out.println(clone.a);

        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");

        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
    }
}
