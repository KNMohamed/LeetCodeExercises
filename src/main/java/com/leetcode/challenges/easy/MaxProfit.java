package com.leetcode.challenges.easy;

public class MaxProfit {
    // Time complexity: O(N)
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int max = 0;
        while(right < prices.length){
            if(prices[left] < prices[right]){
                int diff = prices[right] - prices[left];
                max = Math.max(max,diff);
            }else{
                left = right;
            }
            right++;
        }
        return max;
    }
}
