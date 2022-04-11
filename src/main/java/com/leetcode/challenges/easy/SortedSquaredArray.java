package com.leetcode.challenges.easy;

import java.util.*;

class SortedSquaredArray {

    //ST O(n)
    public static int[] sortedSquaredArray(int[] array) {
        int[] sortedSquares = new int[array.length];
        int smallerValueIdx = 0;
        int largerValueIdx = array.length-1;
        int idx = 0;
        while(smallerValueIdx < largerValueIdx) {
            int smallerValue = array[smallerValueIdx];
            int largerValue = array[largerValueIdx];
            if(Math.abs(smallerValue) > Math.abs(largerValue)){
                sortedSquares[idx++] = smallerValue * smallerValue;
                smallerValueIdx++;
            }else {
                sortedSquares[idx++] = largerValue * largerValue;
                largerValueIdx--;
            }
        }
        return sortedSquares;
    }

    public static void main(String[] args) {
        int[] input = new int[]{-6,-3,1, 2, 3, 5, 6, 8, 9};
        int[] res = SortedSquaredArray.sortedSquaredArray(input);
        Arrays.stream(res).forEach(System.out::println);
    }
}
