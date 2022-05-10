package com.leetcode.challenges.easy;

import java.util.Stack;

public class BaseballGame {
    public static int calPoints(String[] ops) {
        Stack<String> opStack = new Stack<>();
        int totalSum = 0;

        for(String op: ops){
            switch(op){
                case "+":
                    Integer num1 = Integer.valueOf(opStack.pop());
                    Integer num2 = Integer.valueOf(opStack.pop());
                    Integer sum = num1 + num2;
                    opStack.push(num2.toString());
                    opStack.push(num1.toString());
                    opStack.push(sum.toString());
                    break;
                case "D":
                    Integer res = Integer.valueOf(opStack.peek()) * 2;
                    opStack.push(res.toString());
                    break;
                case "C":
                    opStack.pop();
                    break;
                default:
                    opStack.push(op);
            }
        }
        while(!opStack.empty()){
            totalSum += Integer.valueOf(opStack.pop());
        }
        return totalSum;
    }

    public static void main(String[] args) {
        String[] arr = {"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints(arr));
    }
}
