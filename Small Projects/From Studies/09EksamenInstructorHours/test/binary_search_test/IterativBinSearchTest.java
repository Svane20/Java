/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary_search_test;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author erso
 */
public class IterativBinSearchTest {

    private static final int[] FIBOS
            = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55};


    public IterativBinSearchTest() {
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

    @Test
    public void shouldFindIndexOfNumber() {
        // Our version:
        assertEquals(3, IterativBinSearch.find(FIBOS, 3));
        assertEquals(9, IterativBinSearch.find(FIBOS, 55));

        // JDK version:
        assertEquals(3, Arrays.binarySearch(FIBOS, 3));
        assertEquals(9, Arrays.binarySearch(FIBOS, 55));
    }

    @Test
    public void shouldReturnNegativeInsertionPointWhenNotFound() {
        // Our version:
        assertEquals(-1, IterativBinSearch.find(FIBOS, 0));
        assertEquals(-5, IterativBinSearch.find(FIBOS, 4));

        // JDK version:
        assertEquals(-1, Arrays.binarySearch(FIBOS, 0));
        assertEquals(-5, Arrays.binarySearch(FIBOS, 4));
    }
    /**
     * Test of find method, of class IterativBinSearch.
     */
//    @Test
//    public void testFind() {
//        System.out.println("find");
//        int[] numbers = null;
//        int target = 0;
//        int expResult = 0;
//        int result = IterativBinSearch.find(numbers, target);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

}
