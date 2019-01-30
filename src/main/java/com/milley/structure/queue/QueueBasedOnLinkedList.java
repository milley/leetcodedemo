package com.milley.structure.queue;

public class QueueBasedOnLinkedList {
    private Node head = null;
    private Node tail = null;

    public boolean enqueue(String data) {
        Node newNode = new Node(data);
        if (head == null && tail == null) {
            tail = newNode;
            head = newNode;
            return true;
        } else {
            tail.next = newNode;
            tail = tail.next;
            return true;
        }
    }

    public String dequeue() {
        if (head == null) return null;
        Node headNode = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return headNode.getData();
    }

    public void printAll() {
        if (head == null) return;
        Node headNode = head;
        while (headNode != null) {
            System.out.print(headNode.getData() + " ");
            headNode = headNode.next;
        }
        System.out.println();
    }

    public static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(String data) {
            this(data, null);
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
