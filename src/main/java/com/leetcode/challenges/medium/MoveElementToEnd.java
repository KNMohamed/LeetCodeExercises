package com.leetcode.challenges.medium;
import java.util.*;

public class MoveElementToEnd {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int left = 0;
        int right = array.size()-1;

        while(left < right){
            if(array.get(right) == toMove){
                right--;
            }
            if(array.get(left) != toMove){
                left++;
            }
            if(array.get(left) == toMove && array.get(right) != toMove){
                swap(array,left,right);
                left++;
                right--;
            }
        }

        // Write your code here.
        return array;
    }

    public static void swap(List<Integer> array, int left, int right){
        Integer temp = array.get(left);
        array.set(left,array.get(right));
        array.set(right,temp);
    }

    public static void main(String[] args) {
        System.out.println(moveElementToEnd(Arrays.asList(2, 4, 2, 5, 6, 2, 2),2).toString());
    }
}
