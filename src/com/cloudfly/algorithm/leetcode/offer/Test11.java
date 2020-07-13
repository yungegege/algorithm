package com.cloudfly.algorithm.leetcode.offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 */
public class Test11 {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 7, 1, 2, 3, 4, 5};
        int[] arr2 = new int[]{3, 4, 5, 6, 7, 1, 2};
        int[] arr3 = new int[]{1, 3, 5};
        int[] arr4 = new int[]{2, 2, 2, 0, 1};
        int[] arr5 = new int[]{1, 1};
        System.out.println(minArray(arr));
        System.out.println(minArray(arr2));
        System.out.println(minArray(arr3));
        System.out.println(minArray(arr4));
        System.out.println(minArray(arr5));
    }

    public static int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        if (numbers.length == 1 || numbers[left] < numbers[right]) {
            return numbers[left];
        }
        while (left <= right) {
            int mid = left + ((right - left) >> 1);

            if (mid > 0 && numbers[mid] < numbers[mid - 1]) {
                return numbers[mid];
            }
            if (mid < numbers.length - 1 && numbers[mid] > numbers[mid + 1]) {
                return numbers[mid + 1];
            }
            if (numbers[right] > numbers[mid]) {
                // 往左边找
                right = mid - 1;
            } else if (numbers[right] < numbers[mid]) {
                // 往右边找
                left = mid + 1;
            } else {
                right--;
            }
        }
        return numbers[left];
    }
}
