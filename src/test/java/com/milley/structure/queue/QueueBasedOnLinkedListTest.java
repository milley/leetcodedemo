package com.milley.structure.queue;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;

public class QueueBasedOnLinkedListTest {
    private QueueBasedOnLinkedList queueBasedOnLinkedList;

    @Before
    public void init() {
        queueBasedOnLinkedList = new QueueBasedOnLinkedList();
        queueBasedOnLinkedList.enqueue("A");
        queueBasedOnLinkedList.enqueue("B");
        queueBasedOnLinkedList.enqueue("C");
        queueBasedOnLinkedList.enqueue("D");
        queueBasedOnLinkedList.enqueue("E");
        queueBasedOnLinkedList.printAll();
    }

    @Test
    public void dequeueTest() {
        assertEquals("A", queueBasedOnLinkedList.dequeue());
        assertEquals("B", queueBasedOnLinkedList.dequeue());
        assertEquals("C", queueBasedOnLinkedList.dequeue());
        assertEquals("D", queueBasedOnLinkedList.dequeue());
        assertEquals("E", queueBasedOnLinkedList.dequeue());
        assertNull(queueBasedOnLinkedList.dequeue());
        queueBasedOnLinkedList.enqueue("F");
        assertEquals("F", queueBasedOnLinkedList.dequeue());
    }
}
