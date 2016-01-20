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
import java.util.ListIterator;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for MyTrie class
 * @author Hanna_Sira
 */
public class MyTrieTest {

    MyTrie trie;

    public MyTrieTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of add and contains method, of class MyTrie.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        trie = new MyTrie();
        try {
            Scanner in = new Scanner(new File("src\\test\\resources\\words-333333.txt"));
            int subStringPosition = 15; // for given file
            while (in.hasNext()) {
                String word = in.nextLine().substring(subStringPosition);
                trie.add(new Tuple(word));
                assertEquals(true, trie.contains(word));
            }
            in.close();
        } catch (FileNotFoundException ex) {
            System.out.println("file for test is not found");
        }

    }

    /**
     * Test of delete method, of class MyTrie.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        trie = new MyTrie();
        try {
            Scanner in = new Scanner(new File("src\\test\\resources\\words-333333.txt"));
            int subStringPosition = 15; // for given file
            while (in.hasNext()) {
                String word = in.nextLine().substring(subStringPosition);
                trie.add(new Tuple(word));
                assertEquals(true, trie.delete(word));
            }
            in.close();
        } catch (FileNotFoundException ex) {
            System.out.println("file for test is not found");
        }
        assertEquals(false, trie.delete("nonexistingstring"));
    }

    /**
     * Test of words method, of class MyTrie.
     */
    @Test
    public void testWords() {
        System.out.println("words");
        trie = new MyTrie();
        List<String> expectedResult = new ArrayList<String>();
        try {
            Scanner in = new Scanner(new File("src\\test\\resources\\words-333333.txt"));
            int subStringPosition = 15; // for given file
            while (in.hasNext()) {
                String word = in.nextLine().substring(subStringPosition);
                trie.add(new Tuple(word));
                expectedResult.add(word);
            }
            in.close();
        } catch (FileNotFoundException ex) {
            System.out.println("file for test is not found");
        }
        assertEquals(true, expectedResult.contains("more"));

        //code for full checking (requires a lot of time)
//        for(String word:trie.words()){
//            assertEquals(true, expectedResult.contains(word));
//        }
    }

    /**
     * Test of wordsWithPrefix method, of class MyTrie.
     */
    @Test
    public void testWordsWithPrefix() {
        System.out.println("wordsWithPrefix");
        trie = new MyTrie();
        List<String> expectedResult = new ArrayList<String>();
        try {
            Scanner in = new Scanner(new File("src\\test\\resources\\words-333333.txt"));
            int subStringPosition = 15; // for given file
            while (in.hasNext()) {
                String word = in.nextLine().substring(subStringPosition);
                trie.add(new Tuple(word));
                expectedResult.add(word);
            }
            in.close();
        } catch (FileNotFoundException ex) {
            System.out.println("file for test is not found");
        }

        String pref = "mo";

        ListIterator<String> iter = expectedResult.listIterator();

        while (iter.hasNext()) {
            String word = iter.next();
            char arr[] = word.toCharArray();
            if (arr.length > 2) {
                if (arr[0] != 'm' || arr[1] != 'o') {
                    iter.remove();
                }
            } else {
                iter.remove();
            }
        }

        assertEquals(true, expectedResult.contains("more"));

        //code for full checking (requires a lot of time)
//        for(String word:trie.wordsWithPrefix(pref)){
//            assertEquals(true, expectedResult.contains(word));
//        }
    }

    /**
     * Test of size method, of class MyTrie.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        trie = new MyTrie();
        List<String> strFromFile = new ArrayList<String>();
        try {
            Scanner in = new Scanner(new File("src\\test\\resources\\words-333333.txt"));
            int subStringPosition = 15; // for given file
            while (in.hasNext()) {
                String word = in.nextLine().substring(subStringPosition);
                trie.add(new Tuple(word));
                strFromFile.add(word);
            }
            in.close();
        } catch (FileNotFoundException ex) {
            System.out.println("file for test is not found");
        }
        int expected = strFromFile.size();
        assertEquals(expected, trie.size());
    }
}
