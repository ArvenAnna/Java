/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anna.prefixmatches;

/**
 * Interface for Trie structure
 * @author Hanna_Sira
 */
public interface Trie {
    
    /**
     * Add in Trie tuple of term and its weigh as Tuple object
     * @param tuple 
     */
    public void add(Tuple tuple);

    /**
     * Chechs if Trie contains the word
     * @param word given word
     * @return true if contains
     */
    public boolean contains(String word);

    /**
     * Deletes word from Trie
     * @param word word for removing
     * @return true if word was removed
     */
    public boolean delete(String word);

    /**
     * Chooses all words from Trie moving in width
     * @return all words in Trie
     */
    public Iterable<String> words();

    /**
     * Chooses all words from Trie moving in width which starts with prefix pref
     * @param pref prefix
     * @return all words in Trie starts with prefix pref
     */
    public Iterable<String> wordsWithPrefix(String pref);

    /**
     * Counts word's amount in Trie
     * @return Trie size
     */
    public int size();

}
