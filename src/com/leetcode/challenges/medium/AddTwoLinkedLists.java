package com.leetcode.challenges.medium;

import java.math.BigDecimal;
import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoLinkedLists {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        BigDecimal firstNum = BigDecimal.ZERO;
        BigDecimal secondNum = BigDecimal.ZERO;
        int count = 0;
        while(l1 != null || l2 != null) {
            if(l1 != null){
                firstNum = firstNum.add(new BigDecimal(l1.val).scaleByPowerOfTen(count));
                l1 = l1.next;
            }
            if(l2 != null){
                secondNum = secondNum.add(new BigDecimal(l2.val).scaleByPowerOfTen(count));
                l2 = l2.next;
            }
            count++;
        }
        BigDecimal sum = firstNum.add(secondNum);
        if(sum.compareTo(BigDecimal.ZERO) == 0) {
            return new ListNode(0);
        }
        int length = (int)Math.log10(sum.doubleValue()) + 1;        // Get number of digits
        ListNode res = null;
        while(length > 0){
            res = new ListNode(sum.movePointLeft(length-1).remainder(BigDecimal.TEN).intValue(), res);
            length--;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        l1 = new ListNode(6,l1);
        l1 = new ListNode(5,l1);

        ListNode l2 = new ListNode(1);
        l2 = new ListNode(0,l2);
        l2 = new ListNode(0,l2);
        l2 = new ListNode(0,l2);
        l2 = new ListNode(0,l2);
        l2 = new ListNode(0,l2);
        l2 = new ListNode(0,l2);
        l2 = new ListNode(0,l2);
        l2 = new ListNode(0,l2);
        l2 = new ListNode(0,l2);
        l2 = new ListNode(0,l2);
        l2 = new ListNode(0,l2);
        l2 = new ListNode(0,l2);
        l2 = new ListNode(0,l2);
        l2 = new ListNode(0,l2);
        l2 = new ListNode(0,l2);
        l2 = new ListNode(0,l2);
        l2 = new ListNode(0,l2);
        l2 = new ListNode(0,l2);
        l2 = new ListNode(0,l2);
        l2 = new ListNode(0,l2);
        l2 = new ListNode(0,l2);
        l2 = new ListNode(0,l2);
        l2 = new ListNode(0,l2);
        l2 = new ListNode(0,l2);
        l2 = new ListNode(0,l2);
        l2 = new ListNode(0,l2);
        l2 = new ListNode(0,l2);
        l2 = new ListNode(0,l2);
        l2 = new ListNode(0,l2);
        l2 = new ListNode(1,l2);

        AddTwoLinkedLists a = new AddTwoLinkedLists();

        ListNode l3 = a.addTwoNumbers(l1,l2);
        while(l3 != null){
            System.out.print(l3.val);
            l3 = l3.next;
        }
    }
}
