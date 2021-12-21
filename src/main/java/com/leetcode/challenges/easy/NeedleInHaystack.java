package com.leetcode.challenges.easy;

import java.util.Arrays;

/**
 * Given a string and a stubstring return the first occurence(index) of a substring
 * Using the Knuth–Morris–Pratt(KMP) Algorithm this runs in O(N+M) time
 * Note: returns -1 if the substring is not found and returns 0 if the substring is an empty string
 */
public class NeedleInHaystack {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()) return 0;
        if(needle.length() > haystack.length()) return -1;

        int[] arr = GeneratePrefixLookupTable(needle);
        System.out.println(Arrays.toString(arr));

        int j = 0;
        for(int i = 0; i < haystack.length();) {
            if (haystack.charAt(i) == needle.charAt(j)){
                if(j == needle.length()-1)
                    return i-j;
                i++;
                j++;
            }else{
                if(j != 0)
                    j = arr[j-1];
                else
                    i++;
            }
        }
        return -1;
    }

    //O(N)
    private int[] GeneratePrefixLookupTable(String str){
        int[] arr = new int[str.length()];
        int j = 0;
        for(int i = 1; i < str.length();){
            if(str.charAt(i) == str.charAt(j)) {
                arr[i] = j + 1;
                j++;
                i++;
            }else{
                if(j != 0){
                    j = arr[j-1];
                }else{
                    arr[i] = j;
                    i++;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        NeedleInHaystack nih = new NeedleInHaystack();
        int idx = nih.strStr("ababaaba","dab");
        System.out.println(idx);
    }
}
