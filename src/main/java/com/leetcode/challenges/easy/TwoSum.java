package com.leetcode.challenges.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // Find sum in O(N) time
    public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> map = new HashMap<>();
            for(int i=0;i<nums.length;i++){
                if(map.get(nums[i]) == null){
                    map.put(target-nums[i],i);
                }else{
                    return new int[]{map.get(nums[i]),i};
                }
            }
            //No Solution
            return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();

        int nums[] = {4,6,10,22};
        int[] res = twoSum.twoSum(nums,14);

        Arrays.stream(res).forEach(System.out::println);
    }
}
