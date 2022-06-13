package com.leetcode.challenges.medium;

import static com.leetcode.challenges.medium.CustomDLL.Node;
import java.util.HashMap;
import java.util.Map;
/***
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 */
public class LRUCache {
    private Map<Integer,Node> map;
    private CustomDLL dll;
    private int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        dll = new CustomDLL();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            dll.moveToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            dll.moveToHead(node);
            node.val = value;
        }else{
            Node node = new Node(key,value);
            if(map.size() == capacity){
                map.remove(dll.getTail().key);
                dll.removeTail();
            }
            dll.addToHead(node);
            map.put(key,node);
        }
    }
}