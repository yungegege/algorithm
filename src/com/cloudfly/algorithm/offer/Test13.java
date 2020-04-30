package com.cloudfly.algorithm.offer;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * @program: algorithm
 * @author: yunfeili6
 * @create: 2019-12-09 11:23
 */
public class Test13 {
    public static void main(String[] args) {
        new Test13().reOrderArray1(new int[]{1,2,4,3,6,5,7,8});
        new Test13().reOrderArray2(new int[]{4,2,7,35,2,63,2,1,36,25});
//        new Test13().findOdd(5,new int[]{1,2,3,4,5,6,7,8});
    }

    /**
     * 从左到右找奇数,找到就插在左边。。。。奇数和奇数，偶数和偶数之间的相对位置不变
     * @param arr
     */
    private void reOrderArray1(int[] arr) {

    }


    /**
     * 从左到右找偶数,从右到左找奇数,交换 。。。奇数和奇数，偶数和偶数之间的相对位置变化。
     */
    public void reOrderArray2(int [] array) {
        int odd = array.length-1;
        int even = 0;
        int oddIndex = -1;
        int evenIndex = -1;
        while (odd>even){
            oddIndex = findOdd(odd,array);
            evenIndex = findEven(even,array);
            odd = oddIndex;
            even = evenIndex;
            if(oddIndex>=0 && evenIndex>=0 && oddIndex>evenIndex){
                swap(array,oddIndex,evenIndex);
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

    private void swap(int[] array, int oddIndex, int evenIndex) {
        int a = array[oddIndex];
        array[oddIndex] = array[evenIndex];
        array[evenIndex] = a;
    }

    private int findEven(int even,int[] array) {
        for (int i = even; i < array.length; i++) {
            if (array[i]%2==0){
                return i;
            }
        }
        return -1;
    }

    private int findOdd(int odd,int[] array) {
        for (int i = odd; i >=0; i--) {
            if (array[i]%2==1){
                return i;
            }
        }
        return -1;
    }
}
