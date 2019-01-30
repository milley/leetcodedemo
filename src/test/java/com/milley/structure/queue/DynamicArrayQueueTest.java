package com.milley.structure.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class DynamicArrayQueueTest {
    private DynamicArrayQueue dynamicArrayQueue;

    @Before
    public void init() {
        dynamicArrayQueue = new DynamicArrayQueue(5);
        dynamicArrayQueue.enqueue("A");
        dynamicArrayQueue.enqueue("B");
        dynamicArrayQueue.enqueue("C");
        dynamicArrayQueue.enqueue("D");
        dynamicArrayQueue.enqueue("E");
        dynamicArrayQueue.printAll();
    }

    @Test
    public void dequeueTest() {
        assertEquals("A", dynamicArrayQueue.dequeue());
        assertEquals("B", dynamicArrayQueue.dequeue());
        assertEquals("C", dynamicArrayQueue.dequeue());
        assertEquals("D", dynamicArrayQueue.dequeue());
        assertEquals("E", dynamicArrayQueue.dequeue());
        assertNull(dynamicArrayQueue.dequeue());
        assertTrue(dynamicArrayQueue.enqueue("F"));
        assertEquals("F", dynamicArrayQueue.dequeue());
    }
}
