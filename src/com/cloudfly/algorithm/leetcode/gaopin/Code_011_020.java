package com.cloudfly.algorithm.leetcode.gaopin;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class Code_011_020 {

    public static void main(String[] args) {

    }

    public boolean isValid(String s) {
        if(s.length()%2==1){
            return false;
        }
        Stack<Character> stack = new Stack();
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='{' || s.charAt(i)=='[' || s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty() || map.get(stack.pop())!=s.charAt(i)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
