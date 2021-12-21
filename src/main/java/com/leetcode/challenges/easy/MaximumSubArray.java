package com.leetcode.challenges.easy;

/**
 * Given an integer array nums,
 * find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * A subarray is a contiguous part of an array.
 */
public class MaximumSubArray {

    /**
     * In-place algorithm to find the maximum sum in a contiguous part of array nums
     * @param nums
     * @return max
     */
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        for(int i = 1; i<nums.length ; i++){
            nums[i] = Math.max(nums[i],nums[i-1]+nums[i]);
            max = nums[i] > max ? nums[i] : max;
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSubArray msa = new MaximumSubArray();
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int max = msa.maxSubArray(arr);
        System.out.println(max);
    }

}
