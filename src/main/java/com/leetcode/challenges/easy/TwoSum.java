package com.leetcode.challenges.easy;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class TwoSum {

    // Find sum in O(N) time
    public int[] twoSum(int[] nums, int target) {
            HashSet<Integer> set = new HashSet<>();
            for(int i=0;i<nums.length;i++){
                if(!set.contains(target-nums[i])){
                    set.add(nums[i]);
                }else{
                    return new int[]{nums[i],target-nums[i]};
                }
            }
            //No Solution
            return new int[0];
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();

        int nums[] = {4,6,10,22};
        int[] res = twoSum.twoSum(nums,14);

        Arrays.stream(res).forEach(System.out::println);
    }
}
