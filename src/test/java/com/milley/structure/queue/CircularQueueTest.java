package com.milley.structure.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CircularQueueTest {
    private CircularQueue circularQueue;

    @Before
    public void init() {
        circularQueue = new CircularQueue(5);
        circularQueue.enqueue("A");
        circularQueue.enqueue("B");
        circularQueue.enqueue("C");
        circularQueue.printAll();
    }

    @Test
    public void enqueueTest() {
        circularQueue.enqueue("D");
        assertEquals("A", circularQueue.dequeue());
        circularQueue.enqueue("E");
        circularQueue.enqueue("F");
        assertFalse(circularQueue.enqueue("G"));
        circularQueue.printAll();
    }

    @Test
    public void dequeueTest() {
        circularQueue.enqueue("D");
        assertFalse(circularQueue.enqueue("E"));
        circularQueue.printAll();
        assertEquals("A", circularQueue.dequeue());
        assertEquals("B", circularQueue.dequeue());
        assertEquals("C", circularQueue.dequeue());
        assertEquals("D", circularQueue.dequeue());
        assertNotEquals("E", circularQueue.dequeue());
        assertNull(circularQueue.dequeue());
    }
}
