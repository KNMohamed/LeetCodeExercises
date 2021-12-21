package com.leetcode.challenges.easy;

import java.util.Arrays;

/**
 * Problem: Given an integer array nums and an integer val, remove all occurrences of val in nums
 * Limitations: in-place algorithm. Should run in O(N) in worst case
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2};
        RemoveElement r = new RemoveElement();
        int k = r.removeElement(arr,2);
        System.out.println(k);
        for(int a: arr) System.out.print(a + " ");
    }
}
