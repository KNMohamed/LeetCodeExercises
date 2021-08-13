package com.leetcode.challenges.medium;

import java.util.HashMap;
import java.util.Map;

public class CanSum {

    private static Map<Integer, Boolean> map = new HashMap<Integer,Boolean>();
    public static void main(String[] args) {
        int[] arr = {7,14};
        boolean result = CanSum.solve(300,arr);
        System.out.println(result);
    }

    public static boolean solve(int target, int[] arr) {
        if(map.containsKey(target)) return map.get(target);

        if (target == 0) return true;
        if(target < 0) return false;

        for (int num : arr) {
            int remainder = target-num;

            map.put(target,solve(remainder,arr));

            if(solve(remainder,arr) == true) {
                map.put(target,true);
                return true;
            }
        }
        map.put(target,false);
        return false;
    }
}
