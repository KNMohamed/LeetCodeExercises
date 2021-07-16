package com.leetcode.challenges.medium;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem Description: https://leetcode.com/problems/sell-diminishing-valued-colored-balls/
 * Time Complexity O(NlogN)
 */
public class DiminishingColoredBalls {

    private static long sumFromNtoX(long n, long x){
        return ((n*(n+1))/2 - (x *(x+1))/2);
    }

    public static int maxProfit(int[] inventory, int orders) {
        long res = 0;
        int index = inventory.length - 1 ;
        int count = 1;
        Arrays.sort(inventory);

        while(orders > 0){
            if(index > 0 && inventory[index] - inventory[index-1] > 0 && orders >= count*(inventory[index] - inventory[index-1])){
                res += count * sumFromNtoX(inventory[index], inventory[index-1]);
                orders -= count * (inventory[index] -inventory[index-1]);
            }else if(index == 0 || inventory[index] - inventory[index-1] > 0){
                long a = orders/count;
                res += count * sumFromNtoX(inventory[index], inventory[index]-a);
                long b =  orders % count;
                res += b *  (inventory[index]-a);
                orders = 0;
            }
            index--;
            count++;
            res %= 1000000007;
        }
        return (int)res;
    }


    public static void main(String[] args) {
        int[] inventory = {2,4,6,6,9,10};
        int orders = 23;
        int res =DiminishingColoredBalls.maxProfit(inventory,orders);
        System.out.println(res);
    }
}
