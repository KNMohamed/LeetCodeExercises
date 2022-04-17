package com.leetcode.challenges.easy;

import java.util.ArrayList;
import java.util.List;

public class DFSNode {
    public String name;
    public List<DFSNode> children;

    public DFSNode(String name){
        this.name = name;
    }

    public List<String> depthFirstSearch(List<String> array){
        return depthFirstSearch(this, array);
    }

    private List<String> depthFirstSearch(DFSNode node, List<String> array){
        array.add(node.name);
        if(node.children != null){
            node.children.forEach(child -> {
                depthFirstSearch(child,array);
            });
        }
        return array;
    }

    public DFSNode addChild(String name){
        DFSNode child = new DFSNode(name);
        children.add(child);
        return this;
    }

    public static void main(String[] args) {
        DFSNode tree = new DFSNode("A");
        tree.children = new ArrayList<>();
        tree.addChild("B");
        tree.addChild("C");
        tree.addChild("D");

        DFSNode left = tree.children.get(0);
        left.children = new ArrayList<>();

        DFSNode right = tree.children.get(2);
        right.children = new ArrayList<>();

        left.addChild("E");
        left.addChild("F");
        right.addChild("G");
        right.addChild("H");

        left.children.get(1).children = new ArrayList<>();
        left.children.get(1).addChild("I");
        left.children.get(1).addChild("J");

        right.children.get(0).children = new ArrayList<>();
        right.children.get(0).addChild("K");

        List<String> res = tree.depthFirstSearch(new ArrayList<>());
        res.forEach(System.out::println);

    }
}
