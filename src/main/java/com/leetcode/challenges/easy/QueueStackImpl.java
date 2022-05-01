package com.leetcode.challenges.easy;

import java.util.Stack;

public class QueueStackImpl<T extends Comparable<T>> {
    Stack<T> firstStack;
    Stack<T> secondStack;

    public QueueStackImpl() {
        firstStack = new Stack<>();
        secondStack = new Stack<>();
    }

    //Time complexity: O(1)
    public void enque(T data){
        firstStack.push(data);
    }

    //Time complexity: O(N)
    public T dequeue(){
        while(!firstStack.empty()){
            secondStack.push(firstStack.pop());
        }
        if(!secondStack.empty())
            return secondStack.pop();
        return null;
    }

    //Time Complexity: O(N)
    public T peek(){
        while(!firstStack.empty()){
            secondStack.push(firstStack.pop());
        }
        if(!secondStack.empty())
            return secondStack.peek();
        return null;
    }

    public boolean empty(){
        return (firstStack.empty() && secondStack.empty());
    }

    public static void main(String[] args) {
        QueueStackImpl queue = new QueueStackImpl();
        queue.enque(1);
        queue.enque(2);
        queue.enque(3);
        queue.enque(4);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enque(5);
        queue.enque(6);
        queue.enque(7);
        queue.enque(8);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

}
