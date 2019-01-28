package com.milley.structure.stack;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ArrayStackTest {
    ArrayStack arrayStack;

    @Before
    public void init() {
        arrayStack = new ArrayStack(5);
        arrayStack.push("1");
        arrayStack.push("2");
        arrayStack.push("3");
        arrayStack.push("4");
        arrayStack.push("5");
    }

    @Test
    public void pushTest() {
        assertFalse(arrayStack.push("6"));
        System.out.println(arrayStack.pop());
        assertTrue(arrayStack.push("7"));
    }

    @Test
    public void popTest() {
        for (int i = 5; i > 0; i--) {
            assertEquals(String.valueOf(i), arrayStack.pop());
        }
    }
}
