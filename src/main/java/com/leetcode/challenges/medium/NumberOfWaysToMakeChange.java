package com.leetcode.challenges.medium;

public class NumberOfWaysToMakeChange {

    // Space Complexity: O(n) , Time Complexity: O(nd) ;  where n is the change to make and d is the length of denom array.
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[] dp = new int[n+1];
        dp[0] = 1;

        for(int denom: denoms){
            for(int amount = 0; amount < dp.length; amount++){
                if(amount >= denom){
                    dp[amount] += dp[amount-denom];
                }
            }
        }
        return dp[n];
    }
}
