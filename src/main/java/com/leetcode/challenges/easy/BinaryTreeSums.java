package com.leetcode.challenges.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreeSums {
    // This is the class of the input root. Do not edit it.
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        if(root == null) return new ArrayList<>();
        return branchSums(root,new ArrayList<>(),0);
    }

    public static List<Integer> branchSums(BinaryTree root, List<Integer> sums, int sum) {
        sum += root.value;
        if(root.left != null)
            branchSums(root.left,sums,sum);
        if(root.right != null)
            branchSums(root.right,sums,sum);
        if(root.right == null && root.left == null)
            sums.add(sum);
        return sums;
    }

        public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);

        root.left = new BinaryTree(2);
        root.left.left = new BinaryTree(4);
        root.left.right =   new BinaryTree(5);
        root.left.right.left =   new BinaryTree(10);
        root.left.left.left = new BinaryTree(8);
        root.left.left.right = new BinaryTree(9);

        root.right = new BinaryTree(3);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);

        List<Integer> sums = branchSums(root);
        sums.forEach(System.out::println);
    }
}