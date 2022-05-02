package com.leetcode.challenges.medium;

import java.util.*;

class LongestPeak {
    public static int longestPeak(int[] array) {
        int maxCount = 0;
        int i = 1;

        while(i < array.length-1){
            boolean isPeak = array[i-1] < array[i] && array[i] > array[i+1];
            if(!isPeak){
                i++;
                continue;
            }

            int left = i-2;
            int right = i+2;
            while(left >=0 && array[left] < array[left+1]){
                left--;
            }

            while(right <= array.length-1 && array[right-1] > array[right]){
                right++;
            }

            maxCount = Math.max(maxCount,right-left-1);
            i = right;
        }
        return maxCount;
    }
}
