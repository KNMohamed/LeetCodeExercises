package com.leetcode.challenges.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a valid roman numeral, convert it to an integer in O(N) time complexity.
 */
public class RomanToInteger {
    public static int romanToInt(String str) {
        Map<Character,Integer> romanMap = new HashMap<>();
        romanMap.put('I',1);
        romanMap.put('V',5);
        romanMap.put('X',10);
        romanMap.put('L',50);
        romanMap.put('C',100);
        romanMap.put('D',500);
        romanMap.put('M',1000);

        char[] strChars = str.toCharArray();
        int total = romanMap.get(Character.valueOf(strChars[strChars.length-1])).intValue();
        for(int i = strChars.length - 2; i>= 0 ; i--){
            int curr = romanMap.get(Character.valueOf(strChars[i])).intValue();
            int next = romanMap.get(Character.valueOf(strChars[i+1])).intValue();
            if(curr < next){
                total -= curr;
            }else{
                total += curr;
            }
        }
        return total;
    }
}
