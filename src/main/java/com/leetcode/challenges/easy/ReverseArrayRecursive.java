package com.leetcode.challenges.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseArrayRecursive {
    public static List<Integer> reverseArrayRecursive(int[] array){
        if(array.length == 0) return new ArrayList<>();
        return reverseArrayRecursive(array, new ArrayList<>(), array.length-1);
    }

    private static List<Integer> reverseArrayRecursive(int[] array, List<Integer> reversedArray, int index) {
        reversedArray.add(array[index]);
        if(index == 0){
            return reversedArray;
        }
        return reverseArrayRecursive(array,reversedArray,index-1);
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        int[] reversedArray = reverseArrayRecursive(array).stream().mapToInt(Integer::intValue).toArray();
        Arrays.stream(reversedArray).forEach(System.out::println);
    }
}
