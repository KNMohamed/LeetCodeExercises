package com.leetcode.challenges.easy;
import java.util.Arrays;

public class MinimumWaitingTime {
    // O(nlogn) Time complexity : O(1) Space Time Complexity
    public int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);

        int totalWaitingTime = 0;
        for(int i=0; i<queries.length; i++){
            int waitingTime = queries[i];
            int queriesLeft = (queries.length-1-i);
            totalWaitingTime += waitingTime * queriesLeft;
        }
        return totalWaitingTime;
    }
}
