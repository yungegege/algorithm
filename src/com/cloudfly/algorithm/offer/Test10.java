package com.cloudfly.algorithm.offer;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * @program: work
 * @author: yunfeili6
 * @create: 2019-10-25 18:45
 */
public class Test10 {
    public int RectCover(int target) {
        return target<3?target:RectCover(target-1)+RectCover(target-2);
    }

    public static void main(String[] args) {
        System.out.println(new Test10().RectCover(5));
    }
}
