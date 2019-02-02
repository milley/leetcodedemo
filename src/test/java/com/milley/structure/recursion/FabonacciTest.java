package com.milley.structure.recursion;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FabonacciTest {
    private Fabonacci fabonacci;

    @Before
    public void init() {
        fabonacci = new Fabonacci();
    }

    @Test
    public void fTest() {
        assertEquals(1, fabonacci.f(1));
        assertEquals(2, fabonacci.f(2));
        assertEquals(21, fabonacci.f(7));
    }

    @Test
    public void fWithDepthTest() throws Exception {
        assertEquals(1, fabonacci.fWithDepth(1));
        assertEquals(2, fabonacci.fWithDepth(2));
        assertEquals(21, fabonacci.fWithDepth(7));
    }

    @Test
    public void fWithCacheTest() {
        assertEquals(1, fabonacci.fWithCache(1));
        assertEquals(2, fabonacci.fWithCache(2));
        assertEquals(21, fabonacci.fWithCache(7));
    }

    @Test
    public void fWithLoopTest() {
        assertEquals(1, fabonacci.fWithLoop(1));
        assertEquals(2, fabonacci.fWithLoop(2));
        assertEquals(21, fabonacci.fWithLoop(7));
    }
}
