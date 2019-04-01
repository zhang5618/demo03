package com.test;

import java.util.HashSet;

public class Test2 {
    public static void main(String[] args) {
        HashSet<Object> set = new HashSet<>();
        set.add(1);
        set.add(3);
        set.add(4);
        String s = set.toString();
        System.out.println(s.substring(1,s.length()-1));//截取前后乱高端的【】
    }
}
