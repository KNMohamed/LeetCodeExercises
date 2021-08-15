package com.leetcode.challenges.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class BestSum {
    private Map<Integer, List<Integer>> memo;

    public BestSum(){
        memo = new HashMap<>();
    }

    /**
     * @param targetSum target sum
     * @param numbers number array used to reach target sum.
     * @return an array containing the shortest combination from the numbers array which will add up to targetSum
     *
     * depth is at most k
     * branches at most n times with n being numbers.size()
     * Without memoization:
     *   time: O(N^K*K)
     *   space: O(k^2) because call stack is k and stores k each call.
     * with memoization
     *  time: O(N*K^2)
     *  space: O(k^2)
     */
    public List<Integer> solve(int targetSum, List<Integer> numbers){
        if(memo.containsKey(targetSum)) return memo.get(targetSum);
        if(targetSum == 0) return new ArrayList<>();
        if(targetSum < 0) return null;

        List<Integer> shortestCombination = null;

        for(Integer num : numbers){
            int remainder = targetSum - num;
            List<Integer> remainderCombination = solve(remainder,numbers);

            if(remainderCombination != null) {
                List<Integer> combination = new ArrayList<>(remainderCombination);
                combination.add(num);
                if(shortestCombination == null || combination.size() < shortestCombination.size()){
                    shortestCombination = combination;
                }
            }
        }
        memo.putIfAbsent(targetSum,shortestCombination);
        return shortestCombination;
    }
}