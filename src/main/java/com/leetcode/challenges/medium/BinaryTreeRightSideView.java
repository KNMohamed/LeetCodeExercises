package com.leetcode.challenges.medium;

import java.util.*;

public class BinaryTreeRightSideView {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode rightSide = null;
            int size = queue.size();

            for(int i=0; i< size; i++){
                TreeNode node = queue.poll();
                if(node != null){
                    rightSide = node;
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if(rightSide != null)
                result.add(rightSide.val);
        }
        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.right = new TreeNode(5);
        tree.right.right = new TreeNode(4);

        List<Integer> res = rightSideView(tree);
        System.out.println(res.toString());
    }
}
