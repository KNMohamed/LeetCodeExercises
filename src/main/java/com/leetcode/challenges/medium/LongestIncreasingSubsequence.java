package com.leetcode.challenges.medium;
import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);

        for(int i = n-2; i >= 0; i--){
            for(int j= n-1; j > i; j--){
                if(nums[i] < nums[j]){
                    dp[i] = Math.max(dp[i],1+dp[j]);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        int res = lengthOfLIS(arr);

        System.out.println(res);
    }
}
