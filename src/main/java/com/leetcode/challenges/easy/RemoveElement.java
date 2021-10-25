package com.leetcode.challenges.easy;

import java.util.Arrays;

/**
 * Problem: Given an integer array nums and an integer val, remove all occurrences of val in nums
 * Limitations: in-place algorithm. Should run in O(N) in worst case
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = nums.length-1;
        while(j >= i){
            if(nums[i] == val){
                if(nums[j] != val) {
                    nums[i++] = nums[j];
                    nums[j] = val;
                }else {
                    j--;
                }
            } else{
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2};
        RemoveElement r = new RemoveElement();
        int k = r.removeElement(arr,2);
        System.out.println(k);
        for(int a: arr) System.out.print(a + " ");
    }
}
