package com.leetcode.challenges.hard;

import java.util.*;
public class LargestRange {
    //Time complexity: O(nlogn) | O(1) space
    public static int[] largestRange(int[] array) {
        int[] largestRange = new int[2];
        int count = 0;

        Arrays.sort(array);
        largestRange[0] = array[0];
        largestRange[1] = array[0];

        for(int i = 1; i < array.length; i++) {
            int elem1 = array[i-1];
            int elem2 = array[i];

            if(elem2 - elem1 == 1 || elem2 - elem1 == 0){
                count ++;
            }else if(count >= largestRange[1] - largestRange[0]){
                largestRange[0] = array[i-count-1];
                largestRange[1] = array[i-1];
                count = 0;
            }else{
                count = 0;
            }
        }

        if(count >= largestRange[1] - largestRange[0]){
            largestRange[0] = array[array.length-count-1];
            largestRange[1] = array[array.length-1];
        }
        // Write your code here.
        return largestRange;
    }

    //ST O(n)
    public static int[] largestRangeOptimal(int[] array) {
        HashMap<Integer,Boolean> map = new HashMap<>();
        int[] largestRange = new int[2];
        largestRange[0] = array[0];
        largestRange[1] = array[0];

        for(int num : array){
            map.put(num,Boolean.TRUE);
        }

        for(int num : array){
            int i = num - 1;
            int j = num + 1;
            int count = 1;
            if(map.get(num) == Boolean.FALSE) {
                continue;
            }
            map.replace(num,Boolean.FALSE);

            while(map.containsKey(i) || map.containsKey(j)) {
                if(map.containsKey(i)){
                    count++;
                    map.replace(i,Boolean.FALSE);
                    i--;
                }
                if(map.containsKey(j)){
                    count++;
                    map.replace(j,Boolean.FALSE);
                    j++;
                }
            }
            if(count > largestRange[1] - largestRange[0]){
                largestRange[0] = i+1;
                largestRange[1] = j-1;
            }
        }
        return largestRange;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 1, 1, 1, 3, 4 };
        int[] largestRange = LargestRange.largestRange(arr);
        System.out.println(Arrays.toString(largestRange));
    }
}
