package com.leetcode.challenges.medium;
import java.util.*;

public class SmallestDifference {

    /*Time Complexity: O(nlogn) + O(mlogm) where n is the size of arrayOne and m is size of arrayTwo
     * Space Complexity: O(1)
     */
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int[] smallestPair = {arrayOne[0],arrayTwo[0]};

        int arrayOneIdx = 0;
        int arrayTwoIdx = 0;
        int smallest = Integer.MAX_VALUE;
        while(arrayOneIdx < arrayOne.length && arrayTwoIdx < arrayTwo.length){
            int arrayOneVal = arrayOne[arrayOneIdx];
            int arrayTwoVal = arrayTwo[arrayTwoIdx];

            int current = Math.abs(arrayOneVal-arrayTwoVal);
            if (current == 0) return new int[]{arrayOneVal,arrayTwoVal};
            if(current < smallest){
                smallest = current;
                smallestPair[0] = arrayOneVal;
                smallestPair[1] = arrayTwoVal;
            }
            if(arrayOneVal < arrayTwoVal){
                arrayOneIdx++;
            }else{
                arrayTwoIdx++;
            }
        }

        return smallestPair;
    }

    public static void main(String[] args) {
        int[] arrayOne = {-1, 3, 5, 10, 20, 28};
        int[] arrayTwo = {15, 17, 26, 134, 135};
        int[] res =SmallestDifference.smallestDifference(arrayOne,arrayTwo);
        Arrays.stream(res).forEach(System.out::println);
    }
}
