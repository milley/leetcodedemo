package com.milley.linklist;

public class LRUBaseLinkedList<T> {

    /**
     *  默认链表容量
     */
    private final static Integer DEFAULT_CAPACITY = 10;

    /**
     *  头结点
     */
    private SNode<T> headNode;

    /**
     *  链表长度
     */
    private Integer length;

    /**
     *  链表容量
     */
    private Integer capacity;

    public LRUBaseLinkedList() {
        this.headNode = new SNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBaseLinkedList(Integer capacity) {
        this.headNode = new SNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public SNode<T> getHeadNode() {
        return headNode;
    }

    public void setHeadNode(SNode<T> headNode) {
        this.headNode = headNode;
    }

    public void add(T data) {
        SNode preNode = findPreNode(data);

        // 链表中存在，删除原数据，再插入到链表头部
        if (preNode != null) {
            deleteElementOptim(preNode);
            insertElementAtBegin(data);
        } else {
            if (length >= this.capacity) {
                // 删除尾节点
                deleteElementAtEnd();
            }
            insertElementAtBegin(data);
        }
    }

    /**
     *  删除preNode节点下一个元素
     * @param preNode
     */
    private void deleteElementOptim(SNode preNode) {
        SNode temp = preNode.next;
        preNode.next = temp.next;
        temp = null;
        length--;
    }

    /**
     *  链表头部插入节点
     * @param data
     */
    private void insertElementAtBegin(T data) {
        SNode next = headNode.next;
        headNode.next = new SNode(data, next);
        length++;
    }

    /**
     *  获取查找元素前一个节点
     * @param data
     * @return
     */
    private SNode findPreNode(T data) {
        SNode node = headNode;
        while (node.next != null) {
            if (data.equals(node.getNext().getElement())) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    /**
     *  删除尾节点
     */
    private void deleteElementAtEnd() {
        SNode ptr = headNode;
        if (ptr.next == null) {
            return;
        }

        while (ptr.next.next != null) {
            ptr = ptr.next;
        }

        SNode tmp = ptr.next;
        ptr.next = null;
        tmp = null;
        length--;
    }

    public class SNode<T> {
        private T element;
        private SNode next;

        public SNode(T element) {
            this.element = element;
        }

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        public SNode() {
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }
}
