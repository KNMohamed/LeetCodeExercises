package com.leetcode.challenges.medium;
import java.util.Arrays;

/**
 * Problem Description: https://leetcode.com/problems/sell-diminishing-valued-colored-balls/
 * Time Complexity O(NlogN)
 */
public class DiminishingColoredBalls {
    public static int maxProfit(int[] inventory, int orders) {
        long value = 0;
        Arrays.sort(inventory);
        int index = inventory.length-1;
        while(orders > 0){
            if(index == 0) {
                value += inventory[index]--;
                orders--;
                index = inventory.length - 1;
            }else {
                if(index != inventory.length - 1){
                    if (inventory[index] < inventory[index + 1] ){
                        index ++;
                        continue;
                    }
                }
                if (inventory[index] > inventory[index - 1] ) {
                    value += inventory[index]--;
                    orders--;
                } else {
                    index--;
                }
            }
            value %= 1000000007;
        }
        return (int)value ;
    }

    public static void main(String[] args) {
        int[] inventory = {1000000000};
        int orders = 1000000000;
        int res =DiminishingColoredBalls.maxProfit(inventory,orders);
        System.out.println(res);
    }
}
