package com.milley.structure.Sorts;

import com.milley.structure.sorts.QuickSort;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuickSortTest {
    private int[] a1;

    @Before
    public void init() {
        a1 = new int[]{4, 5, 6, 1, 2, 3};
    }

    @Test
    public void quickSortTest() {
        QuickSort.quickSort(a1, a1.length);
        QuickSort.printAll(a1);
        assertElementsByA1();
    }

    private void assertElementsByA1() {
        assertEquals(1, a1[0]);
        assertEquals(2, a1[1]);
        assertEquals(3, a1[2]);
        assertEquals(4, a1[3]);
        assertEquals(5, a1[4]);
        assertEquals(6, a1[5]);
    }
}
