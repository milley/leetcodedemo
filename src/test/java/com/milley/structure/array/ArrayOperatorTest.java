package com.milley.structure.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayOperatorTest {
    private ArrayOperator arrayOperator;
    @Before
    public void init() {
        arrayOperator = new ArrayOperator(10);
        arrayOperator.insert(0, 5);
        arrayOperator.insert(1, 6);
        arrayOperator.insert(2, 7);
        arrayOperator.insert(3, 8);
    }

    @Test
    public void getTest() {
        assertEquals(arrayOperator.get(0), 5);
        assertEquals(arrayOperator.get(1), 6);
        assertEquals(arrayOperator.get(2), 7);
        assertEquals(arrayOperator.get(3), 8);
    }

    @Test
    public void insertTest() {
        assertEquals(arrayOperator.count, 4);
        arrayOperator.insert(2, 10);
        assertEquals(arrayOperator.get(2), 10);
        assertEquals(arrayOperator.count, 5);
    }

    @Test
    public void deleteTest() {
        arrayOperator.delete(1);
        assertEquals(arrayOperator.get(1), 7);
        assertEquals(arrayOperator.count, 3);
        arrayOperator.delete(2);
        assertEquals(arrayOperator.count, 2);
    }
}
