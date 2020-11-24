package com.cloudfly.algorithm.jvm.classloader;

import java.lang.String;

public class Test_1 extends ClassLoader{

    public static void main(String[] args) throws Exception{
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);

        ClassLoader bootStrapClassLoader = extClassLoader.getParent();
        System.out.println(bootStrapClassLoader);

        ClassLoader classLoader = Test_1.class.getClassLoader();
        System.out.println(classLoader);

        Class<?> aClass = systemClassLoader.loadClass("com.cloudfly.algorithm.jvm.classloader.Test");
        System.out.println(aClass);

        Class<?> testClass  = Test.class;
        System.out.println(testClass);

        System.out.println(testClass.newInstance());

        Test_1 test_1 = new Test_1();
        Class<?> aClass1 = test_1.loadClass("java.lang.String");
        System.out.println(aClass1);

        System.out.println(new Test().aaa);

    }
}
