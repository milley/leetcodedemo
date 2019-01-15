package com.milley.structure.linklist;

import com.milley.linklist.LRUBaseLinkedList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LRUBaseLinkedListTest {
    private LRUBaseLinkedList lruBaseLinkedList;

    @Before
    public void init() {
        lruBaseLinkedList = new LRUBaseLinkedList();
        lruBaseLinkedList.add(1);
        lruBaseLinkedList.add(2);
        lruBaseLinkedList.add(3);
        lruBaseLinkedList.add(4);
        lruBaseLinkedList.add(5);
    }

    @Test
    public void addTest() {
        lruBaseLinkedList.add(3);
        LRUBaseLinkedList.SNode head = lruBaseLinkedList.getHeadNode();
        assertEquals(3, head.getNext().getElement());
        assertEquals(5, head.getNext().getNext().getElement());
    }
}
