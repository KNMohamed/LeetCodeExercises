package com.leetcode.challenges.easy;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x >= 0 && x<= 9 ) return true;
        String s = new Integer(x).toString();
        return validate(s,0,s.length()-1);
    }

    private static boolean validate(String s, int beg, int end){
        if(beg > end) return true;
        if(s.charAt(beg) == s.charAt(end))
            return validate(s,beg+1,end-1);
        return false;
    }
}
