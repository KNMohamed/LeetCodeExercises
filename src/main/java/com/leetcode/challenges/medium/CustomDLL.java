package com.leetcode.challenges.medium;

public class CustomDLL {
    Node dummyHead;
    Node dummyTail;

    public CustomDLL(){
        dummyHead = new Node(0,0);
        dummyTail = new Node(0,0);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public void moveToHead(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        addToHead(node);
    }

    public void addToHead(Node node){
        Node temp = dummyHead.next;
        dummyHead.next = node;
        node.prev = dummyHead;
        node.next = temp;
        temp.prev = node;
    }

    public void removeTail(){
        Node newTail = dummyTail.prev.prev;
        newTail.next = dummyTail;
        dummyTail.prev = newTail;
    }

    public Node getTail(){
        return dummyTail.prev;
    }

    public static class Node {
        int key, val;
        Node next,prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
