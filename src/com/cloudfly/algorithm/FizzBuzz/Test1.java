package com.cloudfly.algorithm.FizzBuzz;

/**
 * 注释
 *
 * @program: work
 * @author: yunfeili6
 * @create: 2019-10-25 17:03
 */
public class Test1 {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (i%3==0 && i%5==0){
                System.out.println("FizzBuzz");
            }else if (i%3==0){
                System.out.println("Fizz");
            }else if (i%5==0){
                System.out.println("Buzz");
            }else {
                System.out.println(i);
            }
        }
    }
}
