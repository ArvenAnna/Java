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

/**
 * Test for RVTrie class
 *
 * @author Hanna_Sira
 */
public class MyTrieTest {

    RVTrie trie;

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
     * Test of add and contains methods, of class RVTrie.
     */
    @Test
    public void testAddAndContains() {
        System.out.println("add and contains");
        Tuple tuple = new Tuple("vasilisa");
        trie = new RVTrie();
        trie.add(tuple);
        assertEquals(true, trie.contains("vasilisa"));
    }

    /**
     * Test of add method with null argument, of class RVTrie.
     */
    @Test
    public void testAddWithNullArgument() {
        System.out.println("add");
        Tuple tuple = null;
        int expected = 0;
        trie = new RVTrie();
        trie.add(tuple);
        assertEquals(expected, trie.size());
    }

    /**
     * Test of contains method with null argument, of class RVTrie.
     */
    @Test
    public void testContainsWithNullArgument() {
        System.out.println("contains");
        String word = null;
        trie = new RVTrie();
        assertEquals(false, trie.contains(word));
    }

    /**
     * Test of delete method, of class RVTrie.
     */
    @Test
    public void testDeleteSuccesfully() {
        System.out.println("delete");
        Tuple tuple = new Tuple("vasilisa");
        trie = new RVTrie();
        trie.add(tuple);
        assertEquals(true, trie.delete("vasilisa"));
    }

    /**
     * Test of delete method, of class RVTrie.
     */
    @Test
    public void testDeleteNonSuccesfully() {
        System.out.println("delete");
        trie = new RVTrie();
        assertEquals(false, trie.delete("vasilisa"));
    }

    /**
     * Test of delete method with null argument, of class RVTrie.
     */
    @Test
    public void testDeleteWithNullArgument() {
        System.out.println("delete");
        String word = null;
        trie = new RVTrie();
        assertEquals(false, trie.delete(word));
    }

    /**
     * Test of words method, of class RVTrie.
     */
    @Test
    public void testWords() {
        System.out.println("words");
        Tuple tuple = new Tuple("vasilisa");
        Tuple tuple2 = new Tuple("vas");
        trie = new RVTrie();
        trie.add(tuple);
        trie.add(tuple2);
        Iterator iter = trie.words().iterator();
        assertEquals(true, iter.hasNext());
        assertEquals("vas", iter.next());
        assertEquals(true, iter.hasNext());
        assertEquals("vasilisa", iter.next());
        assertEquals(false, iter.hasNext());
        assertEquals(null, iter.next());
    }

    /**
     * Test of wordsWithPrefix method, of class RVTrie.
     */
    @Test
    public void testWordsWithPrefix() {
        System.out.println("wordsWithPrefix");
        Tuple tuple = new Tuple("vasilisa");
        Tuple tuple2 = new Tuple("vas");
        String pref = "va";
        trie = new RVTrie();
        trie.add(tuple);
        trie.add(tuple2);
        Iterator iter = trie.wordsWithPrefix(pref).iterator();
        assertEquals(true, iter.hasNext());
        assertEquals("vas", iter.next());
        assertEquals(true, iter.hasNext());
        assertEquals("vasilisa", iter.next());
        assertEquals(false, iter.hasNext());
        assertEquals(null, iter.next());
    }
    
    /**
     * Test of wordsWithPrefix method with null argument, of class RVTrie.
     */
    @Test
    public void testWordsWithNullPrefix() {
        System.out.println("wordsWithPrefix");
        Tuple tuple = new Tuple("vasilisa");
        Tuple tuple2 = new Tuple("vas");
        String pref = null;
        trie = new RVTrie();
        trie.add(tuple);
        trie.add(tuple2);
        Iterator iter = trie.wordsWithPrefix(pref).iterator();
        assertEquals(false, iter.hasNext());
        assertEquals(null, iter.next());
    }
    
    /**
     * Test of wordsWithPrefix method wich must return no words, of class RVTrie.
     */
    @Test
    public void testWordsWithPrefixReturnNoWords() {
        System.out.println("wordsWithPrefix");
        Tuple tuple = new Tuple("vasilisa");
        Tuple tuple2 = new Tuple("vas");
        String pref = "fur";
        trie = new RVTrie();
        trie.add(tuple);
        trie.add(tuple2);
        Iterator iter = trie.wordsWithPrefix(pref).iterator();
        assertEquals(false, iter.hasNext());
        assertEquals(null, iter.next());
    }

    /**
     * Test of size method, of class RVTrie.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        Tuple tuple = new Tuple("vasilisa");
        Tuple tuple1 = new Tuple("vasiliy");
        Tuple tuple2 = new Tuple("vas");
        Tuple tuple3 = new Tuple("vasiliy");
        int expected = 3;
        trie = new RVTrie();
        trie.add(tuple);
        trie.add(tuple1);
        trie.add(tuple2);
        trie.add(tuple3);
        assertEquals(expected, trie.size());
    }

    /**
     * Test of size method with empty trie, of class RVTrie.
     */
    @Test
    public void testEmptySize() {
        System.out.println("size");
        int expected = 0;
        trie = new RVTrie();
        assertEquals(expected, trie.size());
    }
}
