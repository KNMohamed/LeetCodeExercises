package com.leetcode.challenges.medium;

import java.util.*;

public class HowSum {

    private static Map<Integer,ArrayList<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        ArrayList<Integer> res = HowSum.solve(300,new int[]{30,14});
        System.out.println(res);
    }

    // Using memoization we achieve
    // Time complexity: O(n*m^2)
    // Space complexity: O(m^2)
    public static ArrayList<Integer> solve(int target, int arr[]){
        if(target == 0) return new ArrayList<Integer>();
        if(target < 0) return null;

        if(map.containsKey(target)){
            return map.get(target);
        }

        for(int x: arr){
            ArrayList<Integer> remainderResult = solve(target-x,arr);
            if(remainderResult != null){
                remainderResult.add(x);
                map.putIfAbsent(target,remainderResult);
                return map.get(target);
            }
        }
        map.putIfAbsent(target,null);
        return null;
    }
}