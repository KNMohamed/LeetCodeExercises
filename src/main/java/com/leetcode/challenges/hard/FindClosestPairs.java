package com.leetcode.challenges.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindClosestPairs {
    // Given two arrays of length n and  m return all pairs of [n,m] that are closest to a given target
    // Time complexity: O(nlogn) + O(mlogm)
    // Space complexity: O(n) + O(m)
    public static List<List<Integer>> findClosestPairs(int target, List<Integer> list1, List<Integer> list2) {
        int m = list1.size();
        int n = list2.size();
        List<Integer> l1 = list1.stream().sorted().collect(Collectors.toList());
        List<Integer> l2 = list2.stream().sorted().collect(Collectors.toList());
        List<List<Integer>> closestPairs = new ArrayList<>();
        int closest = Integer.MAX_VALUE;
        int p1 = 0;
        int p2 = n-1;

        while(p1 < m && p2 >= 0){
            int elem1 = l1.get(p1);
            int elem2 = l2.get(p2);
            int sum = elem1 + elem2;
            int diff  = Math.abs(target-sum);
            if(diff == closest){
                closestPairs.add(Arrays.asList(elem1,elem2));
            }
            if(diff < closest){
                closestPairs = new ArrayList<>();
                closestPairs.add(Arrays.asList(elem1,elem2));
                closest = diff;
            }

            if(sum > target) {
                p2--;
            } else if(sum < target) {
                p1++;
            } else{
                p1++;
                p2--;
            }
        }

        return closestPairs;
    }


    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(-1,3,8,2,9,5);
        List<Integer> l2 = Arrays.asList(4,1,2,10,5,20);
        List<List<Integer>> res = findClosestPairs(20, l1, l2);
        System.out.println(res.toString());
    }
}
