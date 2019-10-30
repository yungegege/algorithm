package com.cloudfly.algorithm.offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * @program: work
 * @author: yunfeili6
 * @create: 2019-10-24 18:43
 */
public class Test6 {
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            if (temp>array[i]){
                return array[i];
            }
            temp = array[i];

        }
        return temp;
    }

    public static void main(String[] args) {
        int[] arr = {5,5,5,8,8,10,2,3,4};
        System.out.println(new Test6().minNumberInRotateArray(arr));
    }

}
