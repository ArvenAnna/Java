/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anna.prefixmatches;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Class represents implementation of Trie interface
 * @author Hanna_Sira
 */
public class MyTrie implements Trie {

    private TrieNode root;
    private static int size;

    public MyTrie() {
        root = new TrieNode(' ', 0);
    }

    @Override
    public void add(Tuple tuple) {
        char arr[] = tuple.getTerm().toCharArray();
        TrieNode node = root;
        int i = 0;
        while (i < arr.length) {
            TrieNode child = node.getChild(arr[i]);
            if (child != null) {
                node = child;
            } else {
                TrieNode newChild = new TrieNode(arr[i], 0);
                node.setChild(newChild);
                node = newChild;
            }
            i++;
        }
        node.setValue(tuple.getWeigh()); //last node is a leaf
    }

    @Override
    public boolean contains(String word) {
        char arr[] = word.toCharArray();
        TrieNode node = root;
        int i = 0;
        while (i < arr.length) {
            TrieNode child = node.getChild(arr[i]);
            if (child == null) {
                return false;
            }
            node = child;
            i++;
        }
        if (node.getValue().equals(0)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean delete(String word) {

        TrieNode currentNode = root;

        List<TrieNode> nodes = new ArrayList<TrieNode>();  //lists for nodes corresonding to given word
        List<Character> keys = new ArrayList<Character>(); //and its keys
        nodes.add(root);
        keys.add(' ');

        char arr[] = word.toCharArray();

        int i = 0;
        while (i < arr.length - 1) {
            TrieNode child = currentNode.getChild(arr[i]);
            if (child != null) {
                currentNode = child;
                nodes.add(currentNode);
                keys.add(currentNode.getKey());
            } else {
                return false; //if node for some letter of world is missing
            }
            i++;
        }
        TrieNode child = currentNode.getChild(arr[i]); //node corresponding to last letter in the word

        if (child.getChildenSize() == 0 && child.getValue() > 0) { //if last node is leaf and nas not children
            child.setValue(0);
            nodes.add(child);
            keys.add(child.getKey());

        }
        if (child.getChildenSize() > 0 && child.getValue() > 0) { //if last node is a leaf and has children
            child.setValue(0);
            return true;
        }
        if (child.getChildenSize() > 0 && child.getValue() == 0) { //if last node is not a leaf and has children
            return false;
        }
        Collections.reverse(nodes); // will be itarate from the end to first

        for (int j = 0; j < nodes.size() - 1; j++) {
            TrieNode node = nodes.get(i);
            if (node.getChildenSize() == 0) {
                TrieNode parent = nodes.get(i + 1);
                parent.deleteChild(node.getKey());
            } else {
                break;
            }
        }
        return true;
    }

    @Override
    public Iterable<String> words() {
        return subTrieWords(root);
    }

    private Iterable<String> subTrieWords(TrieNode subTrieRoot) {
        Queue<TrieNode> nodes = new LinkedList<TrieNode>();
        Queue<String> keys = new LinkedList<String>();

        for (TrieNode node : subTrieRoot.getChildren()) {
            nodes.add(node);
            keys.add(String.valueOf(node.getKey()));
        }
        List<String> words = new ArrayList<String>();
        if (subTrieRoot.getValue() > 0) {
            words.add("");
        }

        boolean flag = true;

        while (flag) {
            Queue<TrieNode> tempNodes = new LinkedList<TrieNode>();
            Queue<String> tempKeys = new LinkedList<String>();
            Iterator<TrieNode> nodesIter = nodes.iterator();
            Iterator<String> keysIter = keys.iterator();

            while (nodesIter.hasNext()) {
                TrieNode node = nodesIter.next();
                String key = keysIter.next();

                if (node.getValue() > 0) {
                    words.add(key);
                }
                for (TrieNode child : node.getChildren()) {
                    tempNodes.add(child);
                    tempKeys.add(key + String.valueOf(child.getKey()));
                }
            }
            nodes = tempNodes;
            keys = tempKeys;
            if (nodes.isEmpty()) {
                flag = false;
            }
        }
        return words;

    }

    @Override
    public Iterable<String> wordsWithPrefix(String pref) {
        char arr[] = pref.toCharArray();
        List<String> output = new ArrayList<String>();
        TrieNode node = root;
        for (char letter : arr) {
            if (node == null) {
                break;
            }
            node = node.getChild(letter);
        }

        if (node != null) {
            Iterable<String> words = subTrieWords(node);
            for (String word : words) {
                output.add(pref + word);
            }
        }
        return output;
    }

    @Override
    public int size() {
        size = 0;
        countSize(root);
        return size;
    }

    /**
     * Counts size of subTrie and writes it to static class field size
     * @param node root for subTrie
     */
    private void countSize(TrieNode node) {
        if (node.getChildenSize() > 0) {
            for (TrieNode child : node.getChildren()) {
                if (child.getValue() > 0) {
                    size++;
                }
                countSize(child);
            }
        }
    }

    /**
     * Class represents node of MyTrie
     */
    private static class TrieNode {

        private final List<TrieNode> children = new ArrayList<TrieNode>();
        private char key;
        private Integer value;

        public TrieNode(char key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public char getKey() {
            return key;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public void setChild(TrieNode node) {
            children.add(node);
        }

        public void deleteChild(char deletedKey) {
            TrieNode deleted = null;
            for (TrieNode node : children) {
                if (node.getKey() == deletedKey) {
                    deleted = node;
                }
            }
            children.remove(deleted);
        }

        public TrieNode getChild(char childKey) {

            for (TrieNode node : children) {
                if (node.getKey() == childKey) {
                    return node;
                }
            }
            return null;
        }

        public int getChildenSize() {
            return children.size();
        }

        public List<TrieNode> getChildren() {
            return children;
        }
        
        @Override
        public String toString() {
            return "TrieNode{" + "key=" + key + ", value=" + value + '}';
        }
    }

}
