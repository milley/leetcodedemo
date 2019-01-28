package com.milley.structure.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackBasedOnLinkedListTest {
    StackBasedOnLinkedList stackBasedOnLinkedList;

    @Before
    public void init() {
        stackBasedOnLinkedList = new StackBasedOnLinkedList();
        stackBasedOnLinkedList.push(1);
        stackBasedOnLinkedList.push(2);
        stackBasedOnLinkedList.push(3);
        stackBasedOnLinkedList.push(4);
        stackBasedOnLinkedList.push(5);
    }

    @Test
    public void pushPopTest() {
        stackBasedOnLinkedList.printAll();
        assertEquals(5, stackBasedOnLinkedList.pop());
        stackBasedOnLinkedList.push(5);
        for (int i = 5; i > 0; i--) {
            assertEquals(i, stackBasedOnLinkedList.pop());
        }
    }
}
