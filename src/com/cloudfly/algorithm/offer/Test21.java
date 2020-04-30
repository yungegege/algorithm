package com.cloudfly.algorithm.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 *
 * @program: algorithm
 * @author: yunfeili6
 * @create: 2019-12-09 11:28
 */
public class Test21 {

    public static void main(String[] args) {
//        System.out.println(new Test21().IsPopOrder(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1}));
        System.out.println(new Test21().IsPopOrder(new int[]{1},new int[]{2}));
    }

    /**
     * 思路：1.push数组加到list里面(为了后续remove)
     *      2.遍历pop数组,如果每个元素a和a的下一个元素b在push数组的索引差大于1,或者元push数组不存在a元素:返回false
     *      3.否则:把元素a从list里面remove,如果不remove,即使是正确的出栈序列,后面的遍历索引差也可能大于1
     *      4.如果上面没有返回false,说明出栈序列是对的，返回true
     *      没有用辅助栈,本思路核心就是第二行,是这个解法的关键
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA==null && popA==null){
            return true;
        }
        if (pushA==null){
            return false;
        }
        if (popA==null){
            return false;
        }
        if (pushA.length!=popA.length){
            return false;
        }
        if (pushA.length==1 && pushA[0]!=popA[0]){
            return false;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i:pushA){
            list.add(i);
        }
        for (int i = 0; i < popA.length-1; i++) {
            if (list.indexOf(popA[i])-list.indexOf(popA[i+1])>1 || !list.contains(popA[i])){
                return false;
            }else {
                list.remove(new Integer(popA[i]));
            }
        }
        return true;
    }
}
