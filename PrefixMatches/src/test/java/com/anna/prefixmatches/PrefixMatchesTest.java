/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anna.prefixmatches;

import java.util.Iterator;
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
        int expResult = 5;
        int result = prefix.add(strings);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of add method with short terms, of class PrefixMatches.
     */
    @Test
    public void testAddUnsuccesfully() {
        System.out.println("add");
        String[] strings = {"by"};
        int expResult = 0;
        int result = prefix.add(strings);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of add method calls Trie.add(), of class PrefixMatches.
     */
    @Test
    public void testAddCallsTrie() {
        System.out.println("add");
        String[] strings = {"bla vasawe", "vassilisa vas g vassilisa"};
        Tuple tuple = new Tuple("bla");
        prefix.add(strings);
        verify(trie).add(tuple);
    }
    
    /**
     * Test of add method not calls Trie.add(), of class PrefixMatches.
     */
    @Test
    public void testAddNotCallsTrie() {
        System.out.println("add");
        String[] strings = {"by"};
        Tuple tuple = new Tuple("by");
        int result = prefix.add(strings);
        verify(trie, never()).add(tuple);
    }


    /**
     * Test of contains method which returns true, of class PrefixMatches.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        String trueWord = "true";
        when(trie.contains(trueWord)).thenReturn(true);
        assertEquals(true, prefix.contains(trueWord));
    }
    
    /**
     * Test of contains method which returns false, of class PrefixMatches.
     */
    @Test
    public void testNonContains() {
        System.out.println("contains");
        String falseWord = "false";
        when(trie.contains(falseWord)).thenReturn(false);
        assertEquals(false, prefix.contains(falseWord));
    }

    /**
     * Test of delete method which returns true, of class PrefixMatches.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String trueWord = "true";   
        when(trie.delete(trueWord)).thenReturn(true);
        assertEquals(true, prefix.delete(trueWord));       
    }
    
    /**
     * Test of delete method which returns false, of class PrefixMatches.
     */
    @Test
    public void testNonDelete() {
        System.out.println("delete");
        String falseWord = "false";   
        when(trie.delete(falseWord)).thenReturn(false);      
        assertEquals(false, prefix.delete(falseWord));
    }

    /**
     * Test of size method, of class PrefixMatches.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        when(trie.size()).thenReturn(8);
        assertEquals(8, prefix.size());
    }

    /**
     * Test of wordsWithPrefix method, of class PrefixMatches.
     */
    @Test
    public void testWordsWithPrefix_String_int() {
        System.out.println("wordsWithPrefix");
        String pref = "vas";
        int k = 1;
        Iterator iter = mock(Iterator.class);
        Iterable iterable = mock(Iterable.class);
        when(trie.wordsWithPrefix(pref)).thenReturn(iterable); 
        when(iterable.iterator()).thenReturn(iter); 
        prefix.wordsWithPrefix(pref, k).iterator().hasNext();
        verify(iter).hasNext();
    }
    
    /**
     * Test of wordsWithPrefix method with null prefix, of class PrefixMatches.
     */
    @Test
    public void testWordsWithNulllPrefix_String_int() {
        System.out.println("wordsWithPrefix");
        String pref = null;
        int k = 1;
        prefix.wordsWithPrefix(pref, k);
        verify(trie, never()).wordsWithPrefix(pref);
    }
    
    /**
     * Test of wordsWithPrefix method with short prefix, of class PrefixMatches.
     */
    @Test
    public void testWordsWithNulllPrefixShortPrefix_String_int() {
        System.out.println("wordsWithPrefix");
        String pref = "d";
        int k = 1;
        Iterator iter = mock(Iterator.class);
        Iterable iterable = mock(Iterable.class);
        when(trie.wordsWithPrefix(pref)).thenReturn(iterable); 
        when(iterable.iterator()).thenReturn(iter); 
        prefix.wordsWithPrefix(pref, k).iterator().hasNext();
        verify(iter, never()).next();
    }
    
    /**
     * Test of wordsWithPrefix method with negative k, of class PrefixMatches.
     */
    @Test
    public void testWordsWithNulllPrefixNegativeK_String_int() {
        System.out.println("wordsWithPrefix");
        String pref = "vas";
        int k = -1;
        prefix.wordsWithPrefix(pref, k);
        verify(trie, never()).wordsWithPrefix(pref);
    }   
}
