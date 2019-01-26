package com.milley.structure.linklist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LinkedListAlgoTest {
    @Test
    public void reverseTest() {
        LinkedListAlgo.Node node3 = new LinkedListAlgo.Node(3, null);
        LinkedListAlgo.Node node2 = new LinkedListAlgo.Node(2, node3);
        LinkedListAlgo.Node node1 = new LinkedListAlgo.Node(1, node2);
        LinkedListAlgo.printAll(node1);
        LinkedListAlgo.Node newNode = LinkedListAlgo.reverse(node1);
        LinkedListAlgo.printAll(newNode);
        assertEquals(3, newNode.getData());
        assertEquals(2, newNode.getNext().getData());
        assertEquals(1, newNode.getNext().getNext().getData());
    }

    @Test
    public void checkCircleTest() {
        LinkedListAlgo.Node nodeCircle2 = new LinkedListAlgo.Node(2, null);
        LinkedListAlgo.Node nodeCircle4 = new LinkedListAlgo.Node(4, nodeCircle2);
        LinkedListAlgo.Node nodeCircle3 = new LinkedListAlgo.Node(3, nodeCircle4);
        nodeCircle2.setNext(nodeCircle3);
        LinkedListAlgo.Node nodeCricle1 = new LinkedListAlgo.Node(1, nodeCircle2);
        assertTrue(LinkedListAlgo.checkCircle(nodeCricle1));

        LinkedListAlgo.Node nodeNonCircle4 = new LinkedListAlgo.Node(4, null);
        LinkedListAlgo.Node nodeNonCircle3 = new LinkedListAlgo.Node(3, nodeNonCircle4);
        LinkedListAlgo.Node nodeNonCircle2 = new LinkedListAlgo.Node(2, nodeNonCircle3);
        LinkedListAlgo.Node nodeNonCircle1 = new LinkedListAlgo.Node(1, nodeNonCircle2);
        assertFalse(LinkedListAlgo.checkCircle(nodeNonCircle1));
    }

    @Test
    public void mergeSortedListsTest() {
        LinkedListAlgo.Node nodeLeft5 = new LinkedListAlgo.Node(5, null);
        LinkedListAlgo.Node nodeLeft3 = new LinkedListAlgo.Node(3, nodeLeft5);
        LinkedListAlgo.Node nodeLeft1 = new LinkedListAlgo.Node(1, nodeLeft3);

        LinkedListAlgo.Node nodeRight7 = new LinkedListAlgo.Node(7, null);
        LinkedListAlgo.Node nodeRight6 = new LinkedListAlgo.Node(6, nodeRight7);
        LinkedListAlgo.Node nodeRight4 = new LinkedListAlgo.Node(4, nodeRight6);
        LinkedListAlgo.Node nodeRight2 = new LinkedListAlgo.Node(2, nodeRight4);

        LinkedListAlgo.Node nodeAll = LinkedListAlgo.mergeSortedLists(nodeLeft1, nodeRight2);
        LinkedListAlgo.printAll(nodeAll);
        assertEquals(1, nodeAll.getData());
        assertEquals(2, nodeAll.getNext().getData());
        assertEquals(3, nodeAll.getNext().getNext().getData());
    }

    @Test
    public void deleteLastKthTest() {
        LinkedListAlgo.Node nodeLeft5 = new LinkedListAlgo.Node(5, null);
        LinkedListAlgo.Node nodeLeft3 = new LinkedListAlgo.Node(3, nodeLeft5);
        LinkedListAlgo.Node nodeLeft1 = new LinkedListAlgo.Node(1, nodeLeft3);
        LinkedListAlgo.Node nodeLeft = LinkedListAlgo.deleteLastKth(nodeLeft1, 2);
        LinkedListAlgo.printAll(nodeLeft);
        assertEquals(1, nodeLeft.getData());
        assertEquals(5, nodeLeft.getNext().getData());

        LinkedListAlgo.Node nodeRight7 = new LinkedListAlgo.Node(7, null);
        LinkedListAlgo.Node nodeRight6 = new LinkedListAlgo.Node(6, nodeRight7);
        LinkedListAlgo.Node nodeRight4 = new LinkedListAlgo.Node(4, nodeRight6);
        LinkedListAlgo.Node nodeRight2 = new LinkedListAlgo.Node(2, nodeRight4);
        LinkedListAlgo.Node nodeRightHead = LinkedListAlgo.deleteLastKth(nodeRight2, 4);
        LinkedListAlgo.printAll(nodeRightHead);
        assertEquals(4, nodeRightHead.getData());
        assertEquals(6, nodeRightHead.getNext().getData());
        assertEquals(7, nodeRightHead.getNext().getNext().getData());

        LinkedListAlgo.Node nodeRightTail = LinkedListAlgo.deleteLastKth(nodeRight2, 0);
        LinkedListAlgo.printAll(nodeRightTail);
        assertEquals(2, nodeRightTail.getData());
        assertEquals(4, nodeRightTail.getNext().getData());
        assertEquals(6, nodeRightTail.getNext().getNext().getData());
    }

    @Test
    public void findMiddleNodeTest() {
        LinkedListAlgo.Node nodeLeft5 = new LinkedListAlgo.Node(5, null);
        LinkedListAlgo.Node nodeLeft3 = new LinkedListAlgo.Node(3, nodeLeft5);
        LinkedListAlgo.Node nodeLeft1 = new LinkedListAlgo.Node(1, nodeLeft3);
        LinkedListAlgo.Node nodeLeftMiddle = LinkedListAlgo.findMiddleNode(nodeLeft1);
        LinkedListAlgo.printAll(nodeLeftMiddle);
        assertEquals(3, nodeLeftMiddle.getData());

        LinkedListAlgo.Node nodeRight7 = new LinkedListAlgo.Node(7, null);
        LinkedListAlgo.Node nodeRight6 = new LinkedListAlgo.Node(6, nodeRight7);
        LinkedListAlgo.Node nodeRight4 = new LinkedListAlgo.Node(4, nodeRight6);
        LinkedListAlgo.Node nodeRight2 = new LinkedListAlgo.Node(2, nodeRight4);
        LinkedListAlgo.Node nodeRightMiddle = LinkedListAlgo.findMiddleNode(nodeRight2);
        LinkedListAlgo.printAll(nodeRightMiddle);
        assertEquals(4, nodeRightMiddle.getData());
    }
}
