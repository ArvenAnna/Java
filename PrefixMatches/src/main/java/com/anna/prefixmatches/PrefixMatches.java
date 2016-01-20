/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anna.prefixmatches;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hanna_Sira
 */
public class PrefixMatches {

    private Trie trie;

    public PrefixMatches(Trie trie) {
        this.trie = trie;
    }

    /**
     * Формирует in-memory словарь слов. 
     * В словарь должны добавляться слова длиннее 2х символов. 
     * Предполагается что знаки пунктуации отсутствуют.
     * @param strings слово, строка, массив слов/строк. 
     * Если приходит строка, то она разбивается на слова по пробелам.
     * @return 
     */
    public int add(String... strings) {
        int count = 0;
        for (String arg : strings) {
            String mas[] = arg.split(" ");
            for (String item : mas) {
                if (item.length() > 2) {
                    count++;
                    Tuple tuple = new Tuple(item);
                    trie.add(tuple);
                }
            }
        }
        return count;
    }

    /**
     * Checks if the word contained in vocabulary
     * @param word given word
     * @return true if contains
     */
    public boolean contains(String word) {
        return trie.contains(word);
    }

    /**
     * Detetes word from vokebulary
     * @param word given word
     * @return 
     */
    public boolean delete(String word) {
        return trie.delete(word);
    }

    /**
     * Counts vocabulary size
     * @return vocabulary size
     */
    public int size() {
        return trie.size();
    }

    // 
    /**
     * Предоставляет набор слов начинающихся с префикса k разных длин
     * @param pref префикс
     * @param k набор длин слов
     * @return если введенный pref длиннее или равен 2м символам, 
     * то возвращает набор слов k разных длин начиная с минимальной, 
     * и начинающихся с данного префикса pref.
     */
    public Iterable<String> wordsWithPrefix(String pref, int k) {
        List<String> words = new ArrayList<String>();
        if (pref.length() >= 2) {

            for (String word : trie.wordsWithPrefix(pref)) {
                if (word.length() <= (pref.length() + k - 1)) {
                    words.add(word);
                }
            }

        }
        return words;
    }

    // 
    /**
     * Предоставляет набор слов начинающихся с префикса длиной pref+2 смвола
     * @param pref
     * @return если введенный pref длиннее или равен 2м символам, 
     * то возвращает набор слов k=3 разных длин начиная с минимальной, 
     * и начинающихся с данного префикса pref.
     */
    public Iterable<String> wordsWithPrefix(String pref) {
        return wordsWithPrefix(pref, 3);
    }

    public static void main(String... args) {
        Trie trie = new MyTrie();
        PrefixMatches matcher = new PrefixMatches(trie); 
        try {
            Scanner in = new Scanner(new File("src\\test\\resources\\words-333333.txt"));
            int subStringPosition = 15; // for given file
            while (in.hasNext()) {
                String word = in.nextLine().substring(subStringPosition);
                matcher.add(word);
            }
            in.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PrefixMatches.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(matcher.contains("ffds"));
        System.out.println(matcher.contains("more"));
        System.out.println(matcher.size());
        System.out.println(matcher.delete("more"));
        System.out.println(matcher.contains("more"));
        
        Iterable<String> list = matcher.wordsWithPrefix("mo", 5);

        System.out.println("----------");
        for (String str : list) {
            System.out.println(str);
        }
    }
}
