package com.milley.structure.search;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTest {
    private int[] a1;
    private int[] a2;
    private int[] a3;
    private int[] a4;

    @Before
    public void init() {
        a1 = new int[]{4, 5, 6, 11, 12, 23};
        a2 = new int[]{4, 5, 5, 5, 12, 23};
        a3 = new int[]{2, 5, 6, 6, 8, 9, 10};
        a4 = new int[]{4, 5, 6, 7, 1, 2, 3};
    }

    @Test
    public void bsearchTest() {
        int index = BinarySearch.bsearch(a1, a1.length, 11);
        assertEquals(3, index);
        index = BinarySearch.bsearch(a1, a1.length, 4);
        assertEquals(0, index);
        index = BinarySearch.bsearch(a1, a1.length, 23);
        assertEquals(5, index);
        index = BinarySearch.bsearch(a1, a1.length, 7);
        assertEquals(-1, index);

        index = BinarySearch.bsearchWithRecursion(a1, a1.length, 11);
        assertEquals(3, index);
        index = BinarySearch.bsearchWithRecursion(a1, a1.length, 4);
        assertEquals(0, index);
        index = BinarySearch.bsearchWithRecursion(a1, a1.length, 23);
        assertEquals(5, index);
        index = BinarySearch.bsearchWithRecursion(a1, a1.length, 7);
        assertEquals(-1, index);
    }

    @Test
    public void binarySearchFirstElementTest() {
        int index = BinarySearch.binarySearchFirstElement(a2, a2.length, 11);
        assertEquals(-1, index);
        index = BinarySearch.binarySearchFirstElement(a2, a2.length, 4);
        assertEquals(0, index);
        index = BinarySearch.binarySearchFirstElement(a2, a2.length, 23);
        assertEquals(5, index);
        index = BinarySearch.binarySearchFirstElement(a2, a2.length, 5);
        assertEquals(1, index);
    }

    @Test
    public void binarySearchLastElementTest() {
        int index = BinarySearch.binarySearchLastElement(a2, a2.length, 11);
        assertEquals(-1, index);
        index = BinarySearch.binarySearchLastElement(a2, a2.length, 4);
        assertEquals(0, index);
        index = BinarySearch.binarySearchLastElement(a2, a2.length, 23);
        assertEquals(5, index);
        index = BinarySearch.binarySearchLastElement(a2, a2.length, 5);
        assertEquals(3, index);
    }

    @Test
    public void binarySearchFirstGreaterThanElementTest() {
        int index = BinarySearch.binarySearchFirstGreaterThanElement(a3, a3.length, 7);
        assertEquals(4, index);
        index = BinarySearch.binarySearchFirstGreaterThanElement(a3, a3.length, 8);
        assertEquals(4, index);
        index = BinarySearch.binarySearchFirstGreaterThanElement(a3, a3.length, 6);
        assertEquals(2, index);
    }

    @Test
    public void binarySearchLastLessThanElementTest() {
        int index = BinarySearch.binarySearchLastLessThanElement(a3, a3.length, 7);
        assertEquals(3, index);
        index = BinarySearch.binarySearchLastLessThanElement(a3, a3.length, 8);
        assertEquals(4, index);
        index = BinarySearch.binarySearchLastLessThanElement(a3, a3.length, 6);
        assertEquals(3, index);
    }

    @Test
    public void binarySearchLoopArrayTest() {
        int index = BinarySearch.binarySearchLoopArray(a4, a4.length, 7);
        assertEquals(3, index);
        index = BinarySearch.binarySearchLoopArray(a4, a4.length, 6);
        assertEquals(2, index);
        index = BinarySearch.binarySearchLoopArray(a4, a4.length, 4);
        assertEquals(0, index);
        index = BinarySearch.binarySearchLoopArray(a4, a4.length, 3);
        assertEquals(6, index);
    }
}
