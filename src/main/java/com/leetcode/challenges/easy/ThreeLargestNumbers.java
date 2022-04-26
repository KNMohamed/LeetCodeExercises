package com.leetcode.challenges.easy;

import java.util.Arrays;

public class ThreeLargestNumbers {
    public static int[] findThreeLargestNumbers(int[] array) {
        int[] threeLargestNumbers = { Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE };
        for (int val: array){
            findHighestIdx(threeLargestNumbers, val);
        }
        return threeLargestNumbers;

    }

    public static void findHighestIdx(int[] maxArray, int target){
        if(target > maxArray[2]){
            shiftAndUpdate(maxArray,target,2);
        } else if(target > maxArray[1]) {
            shiftAndUpdate(maxArray,target,1);
        } else if(target > maxArray[0]) {
            shiftAndUpdate(maxArray,target,0);
        }
    }

    public static void shiftAndUpdate(int[] maxArray, int num, int idx) {
        for(int i = 0; i <= idx; i++){
            if(i == idx){
                maxArray[i] = num;
            }else {
                maxArray[i] = maxArray[i+1];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        Arrays.stream(findThreeLargestNumbers(arr)).forEach(System.out::println);
    }
}
