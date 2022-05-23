package com.leetcode.challenges.easy;

import java.util.Arrays;

public class MaximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int maxNumOfBoxes = truckSize;
        Arrays.sort(boxTypes,(a, b) -> Integer.compare(b[1],a[1]));
        int result = 0;
        for(int i = 0; i < boxTypes.length; i++){
            int[] boxType = boxTypes[i];
            int numberOfBoxes = boxType[0];
            int numberOfUnitsPerBox = boxType[1];

            int n = Math.min(numberOfBoxes,maxNumOfBoxes);
            result += n * numberOfUnitsPerBox;
            maxNumOfBoxes -= numberOfBoxes;
            if(maxNumOfBoxes <= 0) break;
        }
        return result;
    }
}
