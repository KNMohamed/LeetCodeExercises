package com.leetcode.challenges.medium;

public class MaxSubsetSumNoAdjacent {
    public static int maxSubsetSumNoAdjacent(int[] array){
        if(array.length == 0) return 0;
        if(array.length == 1) return array[0];

        int[] maxSums = array.clone();
        maxSums[1] = Math.max(array[0],array[1]);

        for(int i = 2; i < array.length; i++){
            maxSums[i] = Math.max(maxSums[i-1],maxSums[i-2]+maxSums[i]);
        }
        return maxSums[array.length-1];
    }

    public static void main(String[] args) {
        int[] array = {75,105,120,75,90,135};

        int res = maxSubsetSumNoAdjacent(array);
        System.out.println(res);
    }
}
