package com.leetcode.challenges.medium;

public class TotalWaysToMakeChange {
//    Time/Space complexity O(mn)
    public int change(int amount, int[] coins) {
        int m = coins.length+1;
        int n = amount+1;
        int[][] dp = new int[m][n];

        for(int i =0; i < m; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i < m; i++){
            int coin = coins[i-1];
            for(int j = 1; j < n; j++){
                if(j-coin < 0){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coin];
                }
            }
        }

        return dp[m-1][n-1];
    }
}
