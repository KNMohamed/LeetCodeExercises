package com.leetcode.challenges.medium;
import java.util.*;

public class MinNumberOfCoinsForChange {
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int denom: denoms){
            for(int amount = 0; amount < dp.length; amount++){
                if(denom <= amount){
                    int toCompare = 0;
                    if(dp[amount-denom] == Integer.MAX_VALUE){
                        toCompare = dp[amount-denom];
                    }else{
                        toCompare = dp[amount-denom] + 1;
                    }
                    dp[amount] = Math.min(dp[amount],toCompare);
                }
            }
        }
        return dp[dp.length-1] == Integer.MAX_VALUE ? -1 : dp[dp.length-1];
    }
}
