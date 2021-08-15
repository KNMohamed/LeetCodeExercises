package com.leetcode.challenges.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
public class BestSum {
    private static Map<Integer, List<Integer>> memo;
    private static List<Integer> bestSum;

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,5,25);
        int targetSum = 100;
        List<Integer> res = solve(targetSum,numbers);
        res.stream().forEach(System.out::println);
    }

    public static List<Integer> solve(int targetSum, List<Integer> numbers){
        if(targetSum == 0) return new ArrayList<Integer>();
        if(targetSum < 0) return null;

        List<Integer> shortestCombination = null;

        for(Integer num : numbers){
            int remainder = targetSum - num;
            List<Integer> remainderCombination = solve(remainder,numbers);
            if(shortestCombination == null || remainderCombination.size() < shortestCombination.size()){
                shortestCombination = remainderCombination;
            }
        }
        return shortestCombination;
    }
}