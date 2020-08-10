package com.cloudfly.algorithm.leetcode.dailyquestion;

import java.util.ArrayList;
import java.util.List;

public class Code_003_093 {
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
    }

    static List<String> list;

    public static List<String> restoreIpAddresses(String s) {
        list = new ArrayList<>();
        digui(s,0,new String[4]);
        return list;
    }

    public static void digui(String s,int num,String[] arr) {
        if(s.length()==0){
            if(num==4){
                String res = "";
                res+=arr[0];
                res+=".";
                res+=arr[1];
                res+=".";
                res+=arr[2];
                res+=".";
                res+=arr[3];
                list.add(res);
            }
            return;
        }
        if(num>=4){
            return;
        }
        arr[num] = s.substring(0,1);
        digui(s.substring(1),num+1,arr);
        if (!"0".equals(s.substring(0,1))){
            if(s.length()>=2){
                arr[num] = s.substring(0,2);
                digui(s.substring(2),num+1,arr);
            }
            if(s.length()>=3 &&Integer.parseInt(s.substring(0,3))<256){
                arr[num] = s.substring(0,3);
                digui(s.substring(3),num+1,arr);
            }
        }

    }
}
