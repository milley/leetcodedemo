package com.milley.structure.linklist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LRUBaseArrayTest {
    @Test
    public void defaultConstructorTest() {
        LRUBaseArray<Integer> lru = new LRUBaseArray<>();
        lru.offer(1);
        lru.offer(2);
        lru.offer(3);
        lru.offer(4);
        lru.offer(5);
        assertEquals(5, (int)lru.getValueByIndex(0));
        System.out.println(lru);
        lru.offer(6);
        lru.offer(7);
        lru.offer(8);
        lru.offer(9);
        assertEquals(9, (int)lru.getValueByIndex(0));
        System.out.println(lru);
        lru.offer(8);
        assertEquals(8, (int)lru.getValueByIndex(0));
        System.out.println(lru);
    }

    @Test
    public void specifiedConstructorTest() {
        LRUBaseArray<Integer> lru = new LRUBaseArray<>(4);
        lru.offer(1);
        lru.offer(2);
        lru.offer(3);
        lru.offer(4);
        assertEquals(4, (int)lru.getValueByIndex(0));
        lru.offer(2);
        assertEquals(2, (int)lru.getValueByIndex(0));
        assertEquals(4, (int)lru.getValueByIndex(1));
        assertEquals(3, (int)lru.getValueByIndex(2));
        assertEquals(1, (int)lru.getValueByIndex(3));
        lru.offer(4);
        System.out.println(lru);
        assertEquals(4, (int)lru.getValueByIndex(0));
        assertEquals(2, (int)lru.getValueByIndex(1));
        lru.offer(7);
        assertEquals(7, (int)lru.getValueByIndex(0));
        assertEquals(3, (int)lru.getValueByIndex(3));
        System.out.println(lru);
        lru.offer(1);
        System.out.println(lru);
        assertEquals(1, (int)lru.getValueByIndex(0));
        assertEquals(7, (int)lru.getValueByIndex(1));
    }
}
