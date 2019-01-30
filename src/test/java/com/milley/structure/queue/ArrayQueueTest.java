package com.milley.structure.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class ArrayQueueTest {
    private ArrayQueue arrayQueue;

    @Before
    public void init() {
        arrayQueue = new ArrayQueue(5);
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("C");
        arrayQueue.enqueue("D");
        arrayQueue.enqueue("E");
        arrayQueue.printAll();
    }

    @Test
    public void dequeueTest() {
        assertEquals("A", arrayQueue.dequeue());
        assertEquals("B", arrayQueue.dequeue());
        assertEquals("C", arrayQueue.dequeue());
        assertEquals("D", arrayQueue.dequeue());
        assertEquals("E", arrayQueue.dequeue());
        assertNull(arrayQueue.dequeue());
        assertFalse(arrayQueue.enqueue("F"));
    }
}
