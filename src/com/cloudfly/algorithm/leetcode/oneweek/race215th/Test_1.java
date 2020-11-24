package com.cloudfly.algorithm.leetcode.oneweek.race215th;

import java.util.ArrayList;
import java.util.List;

public class Test_1 {

    String[] arr;
    int ptr;

    public Test_1(int n) {
        arr = new String[n];
        ptr = 0;
    }

    public List<String> insert(int id, String value) {
        arr[--id] = value;
        List<String> list = new ArrayList<>();
        if(ptr>=arr.length || arr[ptr]==null){
            return list;
        }
        int i = ptr;
        for(;i<arr.length;i++){
            if(arr[i]!=null){
                list.add(arr[i]);
            }else{
                break;
            }
        }
        ptr = i;
        return list;
    }
}
