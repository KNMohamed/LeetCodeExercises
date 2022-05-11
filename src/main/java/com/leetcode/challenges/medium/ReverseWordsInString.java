package com.leetcode.challenges.medium;

import java.util.Stack;

public class ReverseWordsInString {
    public static String reverseWordsInString(String string) {
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        int n = string.length();

        for(int i = n-1; i >= 0 ; i--){
            char current = string.charAt(i);
            if(current != ' '){
                stack.push(current);
            }else{
                while(!stack.empty()){
                    res.append(stack.pop());
                }
                res.append(current);
            }
        }
        while(!stack.empty()){
            res.append(stack.pop());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = ReverseWordsInString.reverseWordsInString("a ab a");
        System.out.println(s);
    }
}
