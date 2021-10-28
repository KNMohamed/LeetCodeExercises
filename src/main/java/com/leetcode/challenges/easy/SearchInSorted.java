package com.leetcode.challenges.easy;

/**
 * Problem Statement: Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * Limitations: You must write an algorithm with O(log n) runtime complexity.
 * Solution: Refined Binary Search Algorithm
 */
public class SearchInSorted {
    public int searchInsert(int[] nums, int target){
        return searchInsert(nums,0,nums.length-1,target);
    }

    private int searchInsert(int[] nums, int l, int r, int target) {
        if(r >= l){
            int mid = l+(r-l)/2;
            if(nums[mid] == target) return mid;

            if(target < nums[mid])
                return searchInsert(nums,l,mid-1,target);
            return searchInsert(nums,mid+1,r,target);
        }
        if(r<l) return l;
        return r;
    }
}
