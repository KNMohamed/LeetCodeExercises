package com.leetcode.challenges.easy;

public class NodeDepths {
    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static int nodeDepths(BinaryTree root) {
        return nodeDepths(root,0);
    }

    private static int nodeDepths(BinaryTree root, int depth){
        if(root == null) return 0;
        return depth + nodeDepths(root.left,depth+1) + nodeDepths(root.right,depth+1);
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);

        root.left = new BinaryTree(2);
        root.left.left = new BinaryTree(4);
        root.left.right =   new BinaryTree(5);
        root.left.left.left = new BinaryTree(8);
        root.left.left.right = new BinaryTree(9);

        root.right = new BinaryTree(3);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);

        int res = nodeDepths(root);
        System.out.println(res);
    }
}
