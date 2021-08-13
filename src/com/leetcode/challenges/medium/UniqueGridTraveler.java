package com.leetcode.challenges.medium;

import java.util.HashMap;
import java.util.Map;

public class UniqueGridTraveler {

    private static Map<String,Double> memo = new HashMap<>();

    public static void main(String[] args) {
        double x = UniqueGridTraveler.gridTraveler(18,18);
        System.out.println(x);
    }

    // O(N) with memoization
    public static double gridTraveler(int n, int k){
        //Base case
        if(n == 0 || k == 0) return 0.0;
        if(k == 1 || n == 1) return 1.0;
        String key = Integer.toString(n) + "," + Integer.toString(k);

        if(memo.containsKey(key)) return memo.get(key);

        memo.putIfAbsent(key,gridTraveler(n-1,k) + gridTraveler(n,k-1));
        return memo.get(key);
    }
}
