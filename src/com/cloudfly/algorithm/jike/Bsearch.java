package com.cloudfly.algorithm.jike;

/**
 * 注释
 *
 * @program: algorithm
 * @author: yunfeili6
 * @create: 2020-05-27 16:02
 */
public class Bsearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 5, 5, 5, 7, 8, 9};
//        System.out.println(bsearch(arr, 0));
//        System.out.println(bsearch(arr, 1));
//        System.out.println(bsearch(arr, 2));
//        System.out.println(bsearch(arr, 3));
//        System.out.println(bsearch(arr, 4));
//        System.out.println(bsearch(arr, 5));
//        System.out.println(bsearch(arr, 6));
//        System.out.println(bsearch(arr, 7));
//        System.out.println(bsearch(arr, 8));
//        System.out.println(bsearch(arr, 9));
//        System.out.println(bsearch(arr, 10));
        System.out.println(bsearch(arr,arr.length,5));




    }

    public static int bsearch(int[] arr, int val) {
        return bsearch_digui(arr, val, 0, arr.length - 1);
    }

    private static int bsearch_digui(int[] arr, int val, int start, int end) {
        return start > end ? -1 : arr[(start + end) / 2] == val ? (start + end) / 2 : arr[(start + end) / 2] > val ? bsearch_digui(arr, val, start, (start + end) / 2 - 1) : bsearch_digui(arr, val, (start + end) / 2 + 1, end);
    }

    public static int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (low < n && a[low]==value){
            return low;
        } else{
            return -1;
        }
    }
}
