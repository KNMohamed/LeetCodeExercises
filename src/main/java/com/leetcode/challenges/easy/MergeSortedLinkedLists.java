package com.leetcode.challenges.easy;

public class MergeSortedLinkedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode head = l3;
        do {
            if (l1 == null && l2 == null) break;
            if (l1 == null) {
                l3.next = new ListNode(l2.val);
                l2 = l2.next;
            } else if (l2 == null) {
                l3.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                if (l1.val <= l2.val) {
                    l3.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    l3.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
            }
            if (head == null) head = l3;
            l3 = l3.next;
        } while (l1 != null || l2 != null);
        return head.next;
    }
}
