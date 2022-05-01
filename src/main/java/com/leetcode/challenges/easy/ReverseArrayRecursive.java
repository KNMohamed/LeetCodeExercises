package com.leetcode.challenges.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseArrayRecursive {
    public static void reverseArrayRecursive(int[] array){
        if(array.length > 1) {
            reverseArrayRecursive(array,0,array.length - 1);
        }
    }

    private static void reverseArrayRecursive(int[] array, int start, int end) {
        if(start < end){
            swap(array,start,end);
            reverseArrayRecursive(array,start+1,end-1);
        }
    }

    private static void swap(int[] array, int i, int j){
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        reverseArrayRecursive(array);
        Arrays.stream(array).forEach(System.out::println);
    }
}
