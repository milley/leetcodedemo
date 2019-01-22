package com.milley.structure.linklist;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.*;

public class SinglyLinkedListTest {
    private SinglyLinkedList.Node node;
    private SinglyLinkedList singlyLinkedList;

    @Before
    public void init() {
        SinglyLinkedList.Node node5 = SinglyLinkedList.createNode(5);
        SinglyLinkedList.Node node4 = new SinglyLinkedList.Node(4, node5);
        SinglyLinkedList.Node node3 = new SinglyLinkedList.Node(3, node4);
        SinglyLinkedList.Node node2 = new SinglyLinkedList.Node(2, node3);
        SinglyLinkedList.Node node1 = new SinglyLinkedList.Node(1, node2);
        node = node1;
        singlyLinkedList = new SinglyLinkedList(node);
    }

    @Test
    public void findByValueTest() {
        SinglyLinkedList.Node node = singlyLinkedList.findByValue(4);
        assertEquals(4, node.getData());

        SinglyLinkedList.Node node5 = singlyLinkedList.findByValue(5);
        assertEquals(5, node5.getData());

        node = singlyLinkedList.findByValue(6);
        assertNull(node);
    }

    @Test
    public void findByIndexTest() {
        SinglyLinkedList.Node node1 = singlyLinkedList.findByIndex(0);
        assertEquals(1, node1.getData());
        SinglyLinkedList.Node node3 = singlyLinkedList.findByIndex(2);
        assertEquals(3, node3.getData());
        SinglyLinkedList.Node node5 = singlyLinkedList.findByIndex(4);
        assertEquals(5, node5.getData());
        SinglyLinkedList.Node node6 = singlyLinkedList.findByIndex(5);
        assertNull(node6);
    }

    @Test
    public void insertToHeadTest() {
        singlyLinkedList.insertToHead(7);
        assertEquals(7, singlyLinkedList.getHead().getData());
        assertNotEquals(1, singlyLinkedList.getHead().getData());
        singlyLinkedList.insertToHead(8);
        assertEquals(8, singlyLinkedList.getHead().getData());
        assertNotEquals(7, singlyLinkedList.getHead().getData());
    }

    @Test
    public void insertTailTest() {
        singlyLinkedList.insertTail(7);
        assertEquals(7, singlyLinkedList.findByIndex(5).getData());
        singlyLinkedList.insertTail(8);
        assertNotEquals(7, singlyLinkedList.findByIndex(6).getData());
        assertEquals(8, singlyLinkedList.findByIndex(6).getData());
    }

    @Test
    public void insertAfterTest() {
        SinglyLinkedList.Node node3 = singlyLinkedList.findByValue(3);
        singlyLinkedList.insertAfter(node3, 7);
        SinglyLinkedList.Node node4 = singlyLinkedList.findByIndex(3);
        assertEquals(7, node4.getData());

        SinglyLinkedList.Node node5 = singlyLinkedList.findByValue(5);
        singlyLinkedList.insertAfter(node5, 8);
        SinglyLinkedList.Node node6 = singlyLinkedList.findByIndex(6);
        assertEquals(8, node6.getData());
    }

    @Test
    public void insertBeforeTest() {
        SinglyLinkedList.Node node3 = singlyLinkedList.findByValue(3);
        singlyLinkedList.insertBefore(node3, 7);
        assertEquals(7, singlyLinkedList.findByIndex(2).getData());
        SinglyLinkedList.Node node5 = singlyLinkedList.findByValue(5);
        singlyLinkedList.insertBefore(node5, 8);
        assertEquals(8, singlyLinkedList.findByIndex(5).getData());
    }

    @Test
    public void deleteByNodeTest() {
        SinglyLinkedList.Node node1 = singlyLinkedList.findByIndex(0);
        singlyLinkedList.deleteByNode(node1);
        assertEquals(2, singlyLinkedList.findByIndex(0).getData());
        assertNotEquals(1, singlyLinkedList.findByIndex(0).getData());
        SinglyLinkedList.Node node3 = singlyLinkedList.findByValue(3);
        singlyLinkedList.deleteByNode(node3);
        assertEquals(4, singlyLinkedList.findByIndex(1).getData());
        SinglyLinkedList.Node node5 = singlyLinkedList.findByIndex(2);
        singlyLinkedList.deleteByNode(node5);
        assertNull(singlyLinkedList.findByIndex(2));
    }

    @Test
    public void deleteByValueTest() {
        singlyLinkedList.deleteByValue(1);
        assertEquals(2, singlyLinkedList.getHead().getData());
        singlyLinkedList.deleteByValue(3);
        assertEquals(4, singlyLinkedList.findByIndex(1).getData());
        singlyLinkedList.deleteByValue(5);
        assertNull(singlyLinkedList.findByIndex(2));
    }

    @Test
    public void printAllTest() {
        singlyLinkedList.printAll();
    }

    @Test
    public void TFResultTest() {
        SinglyLinkedList.Node leftNode = singlyLinkedList.findByIndex(1);
        SinglyLinkedList.Node rightNode = singlyLinkedList.findByValue(2);
        assertTrue(singlyLinkedList.TFResult(leftNode, rightNode));
        System.out.println("=======================");
        SinglyLinkedList.Node nextNode = singlyLinkedList.findByIndex(0);
        assertFalse(singlyLinkedList.TFResult(leftNode, nextNode));
    }

    @Test
    public void palindromeFalseTest() {
        assertFalse(singlyLinkedList.palindrome());
    }

    @Test
    public void palindromeTrueTest() {
        singlyLinkedList.insertTail(4);
        singlyLinkedList.insertTail(3);
        singlyLinkedList.insertTail(2);
        singlyLinkedList.insertTail(1);
        assertTrue(singlyLinkedList.palindrome());
    }

    @Test
    public void inverseLinkList_headTest() {
        SinglyLinkedList.Node node = singlyLinkedList.inverseLinkList_head(singlyLinkedList.getHead());
        assertEquals(5, node.getNext().getData());
    }

    @Test
    public void inverseLinkListTest() {
        SinglyLinkedList.Node head = singlyLinkedList.getHead();
        SinglyLinkedList.Node reverseNode = singlyLinkedList.inverseLinkList(head);
        assertEquals(5, reverseNode.getData());
        SinglyLinkedList.Node node4 = reverseNode.getNext();
        assertEquals(4, node4.getData());
    }
}
