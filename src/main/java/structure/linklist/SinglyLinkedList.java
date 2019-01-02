package structure.linklist;

/**
 * 1）单链表的插入、删除、查找操作；
 * 2）链表中存储的是int类型的数据；
 */
public class SinglyLinkedList {
    private Node head = null;

    public Node findByValue(int value) {
        for (Node node = head; node.next != null; node = node.next) {
            if (node.data == value) {
                return node;
            }
        }
        return null;
    }

    public Node findByIndex(int index) {
        int i = 0;
        for (Node node = head; node.next != null; node = node.next) {
            if (i == index) {
                return node;
            }
            i++;
        }
        return null;
    }

    //无头结点
    //表头部插入
    //这种操作将于输入的顺序相反，逆序
    public void insertToHead(int value) {
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    public void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    //顺序插入
    //链表尾部插入
    public void insertTail(int value){
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
        } else {
            Node q = head;
            while (q.next != null) {
                q = q.next;
            }
            newNode.next = q.next;
            q.next = newNode;
        }
    }
    public void insertAfter(Node p, int value) {
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }

    public void insertAfter(Node p, Node newNode) {
        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertBefore(Node p, int value) {
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }

    public void insertBefore(Node p, Node newNode) {
        if (p == head) {
            insertToHead(newNode);
            return;
        }

        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }
        if (q == null) {
            return;
        }

        newNode.next = p;
        q.next = newNode;
    }

    public void deleteByNode(Node p) {
        if (p == null || head == null) return;
        if (p == head) {
            head = head.next;
            return;
        }
        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }
        if (q == null) {
            return;
        }
        q.next = q.next.next;
    }

    public void deleteByValue(int value) {
        if (head == null) return;
        Node p = head;
        Node q = null;
        while (p != null && p.data != value) {
            q = p;
            p = p.next;
        }
        if (p == null) return;
        if (q == null) {
            head = head.next;
        } else {
            q.next = q.next.next;
        }
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    //判断true or false
    public boolean TFResult(Node left, Node right){
        Node l = left;
        Node r = right;

        while (l != null && r != null) {
            System.out.println("left_" + l.data);
            System.out.println("right_" + r.data);
            if (l.data == r.data) {
                l = l.next;
                r = r.next;
                continue;
            }
            break;
        }
        if (l == null && r == null) {
            return true;
        }
        return false;
    }
    //　判断是否为回文
    public boolean palindrome(){
        if (head == null) {
            return false;
        } else {
            System.out.println("Start to find the middle item:");
            Node slow = head;
            Node fast = head;
            if (slow.next == null) {
                System.out.println("The size = 1");
                return true;
            } else {
                while (slow.next != null && fast.next != null) {
                    slow = slow.next;
                    fast = fast.next.next;
                }

                System.out.println("The middle item:" + slow.data);
                Node left = null;
                Node right = null;
                if (fast.next == null) {
                    right = slow.next;
                    left = inverseLinkList(slow);
                    System.out.println("The first left item: %d" + left.data);
                    System.out.println("The first right item: %d" + right.data);
                } else {
                    right = slow.next;
                    left = inverseLinkList(slow);
                }
                return TFResult(left, right);
            }
        }
    }

    //带结点的链表翻转
    public Node inverseLinkList_head(Node p){
        Node Head = p;
        Node cur = p.next;
        Node next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = Head.next;
            Head.next = cur;
            cur = next;
        }
        return Head;
    }

    //无头结点的链表翻转
    public Node inverseLinkList(Node p){
        Node pre = null;
        Node r = head;
        Node next = null;
        while (r.next != null) {
            next = r.next;
            r.next = pre;
            pre = r;
            r = next;
        }
        r.next = pre;
        return r;
    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }


    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}
