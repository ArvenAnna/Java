/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anna.prefixmatches;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Test for PrefixMatcher class
 * @author Hanna_Sira
 */
public class PrefixMatchesTest {
    
    private PrefixMatches prefix;
    private Trie trie;
    
    public PrefixMatchesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        trie = mock(Trie.class);
        prefix = new PrefixMatches(trie);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class PrefixMatches.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        String[] strings = {"bla vasawe", "vassilisa vas g vassilisa"};
        Tuple tuple = new Tuple("bla");
        Tuple tuple2 = new Tuple("vasawe");
        Tuple tuple3 = new Tuple("g");
        int expResult = 5;
        int result = prefix.add(strings);
        verify(trie).add(tuple);
        verify(trie).add(tuple2);
        verify(trie, never()).add(tuple3);
        assertEquals(expResult, result);
    }

    /**
     * Test of contains method, of class PrefixMatches.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        String trueWord = "true";
        String falseWord = "false";
        when(trie.contains(trueWord)).thenReturn(true);
        when(trie.contains(falseWord)).thenReturn(false);
        assertEquals(true, prefix.contains(trueWord));
        assertEquals(false, prefix.contains(falseWord));
    }

    /**
     * Test of delete method, of class PrefixMatches.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String trueWord = "true";
        String falseWord = "false";   
        when(trie.delete(trueWord)).thenReturn(true);
        when(trie.delete(falseWord)).thenReturn(false);
        assertEquals(true, prefix.delete(trueWord));       
        assertEquals(false, prefix.delete(falseWord));
    }

    /**
     * Test of size method, of class PrefixMatches.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        when(trie.size()).thenReturn(8);
        int result = prefix.size();
        assertEquals(8, result);
    }

    /**
     * Test of wordsWithPrefix method, of class PrefixMatches.
     */
    @Test
    public void testWordsWithPrefix_String_int() {
        System.out.println("wordsWithPrefix");
        String pref = "vas";
        int k = 1;
        List<String> trieReturn = new ArrayList<String>();
        trieReturn.add("vas");
        trieReturn.add("vassilisa");
        trieReturn.add("vasya");
        trieReturn.add("vasiliy");
        when(trie.wordsWithPrefix(pref)).thenReturn(trieReturn);    
        List<String> expResult = new ArrayList<String>();
        expResult.add("vas");        
        assertEquals(expResult, prefix.wordsWithPrefix(pref, k));
    }

    /**
     * Test of wordsWithPrefix method, of class PrefixMatches.
     */
    @Test
    public void testWordsWithPrefix_String() {
        System.out.println("wordsWithPrefix");
        String pref = "vas";        
        List<String> trieReturn = new ArrayList<String>();
        trieReturn.add("vas");
        trieReturn.add("vassilisa");
        trieReturn.add("vasya");
        trieReturn.add("vasiliy");        
        when(trie.wordsWithPrefix(pref)).thenReturn(trieReturn);        
        List<String> expResult = new ArrayList<String>();        
        expResult.add("vas");
        expResult.add("vasya");        
        assertEquals(expResult, prefix.wordsWithPrefix(pref, 3));

    }

    /**
     * Test of main method, of class PrefixMatches.
     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//    }
    
}
