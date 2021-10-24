package com.leetcode.challenges.easy;

/**
 * Problem: Remove Duplicates from Sorted Array
 * Limitations: Solve In place in O(N) time
 */
public class RemoveSortedDuplicates {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[i] != nums[j]){
                nums[++i] = nums[j];
            }
        }
        return ++i;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,2,3,3};
        RemoveSortedDuplicates r = new RemoveSortedDuplicates();
        int k = r.removeDuplicates(arr);
        System.out.println(k);
    }
}
