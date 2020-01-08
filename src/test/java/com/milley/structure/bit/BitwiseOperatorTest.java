package com.milley.structure.bit;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BitwiseOperatorTest {
    @Test
    public void xorOperatorTest() {
        int x = 3;
        assertEquals(x, x ^ 0);
        System.out.println(Integer.MAX_VALUE);  // 2147483647
        System.out.println(x ^ Integer.MAX_VALUE);  // 2147483644
        assertEquals(Integer.MAX_VALUE - x, x ^ Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, x ^ (Integer.MAX_VALUE - x));
        assertEquals(0, x ^ x);

        int y = 4;
        int z = x ^ y;
        assertEquals(y, x ^ z);
        assertEquals(x, y ^ z);

        assertEquals(x ^ y ^ z, x ^ (y ^ z));
        assertEquals(x ^ y ^ z, (x ^ y) ^ z);
    }

    @Test
    public void combinationTest() {
        int x = 7;
        // 1
        assertEquals(4, x & (Integer.MAX_VALUE << 2));

        // 2
        assertEquals(1, (x >> 2) & 1);
        assertEquals(0, (x >> 3) & 1);

        // 3
        assertEquals(4, x & (1 << (3 - 1)));

        // 4
        assertEquals(15, x | (1 << 3));

        // 5
        assertEquals(3, x & (~(1 << 2)));

        // 6
        assertEquals(1, x & ((1 << 1) - 1));

        // 7
        assertEquals(4, x & (~((1 << (1 + 1)) - 1)));
    }

    @Test
    public void commonlyOperatorTest() {
        int x = 7;
        // 1
        assertEquals(1, x & 1);
        assertEquals(0, x & 0);

        // 2
        assertEquals(6, x & (x - 1));

        // 3
        assertEquals(1, x & (-x));
    }
}
