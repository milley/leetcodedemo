package com.milley.structure.recursion;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {
    private Fibonacci fibonacci;

    @Before
    public void init() {
        fibonacci = new Fibonacci();
    }

    @Test
    public void fTest() {
        assertEquals(1, fibonacci.f(1));
        assertEquals(2, fibonacci.f(2));
        assertEquals(21, fibonacci.f(7));
    }

    @Test
    public void fWithDepthTest() throws Exception {
        assertEquals(1, fibonacci.fWithDepth(1));
        assertEquals(2, fibonacci.fWithDepth(2));
        assertEquals(21, fibonacci.fWithDepth(7));
    }

    @Test
    public void fWithCacheTest() {
        assertEquals(1, fibonacci.fWithCache(1));
        assertEquals(2, fibonacci.fWithCache(2));
        assertEquals(21, fibonacci.fWithCache(7));
    }

    @Test
    public void fWithLoopTest() {
        assertEquals(1, fibonacci.fWithLoop(1));
        assertEquals(2, fibonacci.fWithLoop(2));
        assertEquals(21, fibonacci.fWithLoop(7));
    }
}
