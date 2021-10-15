package com.leetcode.challenges.easy;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 */
public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();

        boolean isTrue = true;
        for(char c: s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(Character.valueOf(c));
            }else if(c == ')' || c == '}' || c == ']'){
                if(stack.isEmpty()){
                    isTrue = false;
                    break;
                }
                char p = stack.pop().charValue();
                if(p == '(' && c != ')' || p == '{' && c != '}' || p == '[' && c != ']') {
                    isTrue = false;
                    break;
                }
            }
        }
        if(!stack.isEmpty()) return false;
        return isTrue;
    }

    public static void main(String[] args) {
        System.out.println(ValidParentheses.isValid("()"));
    }
}
