package com.leetcode.challenges.easy;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder longestPrefix = new StringBuilder(strs[0]);
        for(int i = 1; i < strs.length; i++){
            String comp = strs[i];
            if(comp.equals(longestPrefix.toString())) continue;
            if(comp.equals("")){
                longestPrefix.delete(0,longestPrefix.length());
                break;
            }

            int j;
            for(j = 0; j < Math.min(longestPrefix.length(),comp.length()); j++){
                if(longestPrefix.charAt(j) != comp.charAt(j)) break;
            }
            if(j == 0){
                longestPrefix.delete(0,longestPrefix.length());
                break;
            }
            longestPrefix.delete(j,longestPrefix.length());
        }
        return longestPrefix.toString();
    }
}
