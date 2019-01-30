package com.milley.structure.queue;

public class DynamicArrayQueue {
    // 数组： items, 数组大小： n
    private String[] items;
    private int n = 0;
    // head表示头下标，tail表示尾下标
    private int head = 0;
    private int tail = 0;

    public DynamicArrayQueue(int capacity) {
        this.items = new String[capacity];
        this.n = capacity;
    }

    public boolean enqueue(String item) {
        // 如果tail==n表示队列已经满了
        if (tail == n) {
            // tail == n && head == 0, 表示整个队列都占满了
            if (head == 0) return false;
            // 数据搬移
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
        }
        items[tail] = item;
        ++tail;
        return true;
    }

    public String dequeue() {
        // 如果head==tail表示队列为空
        if (head == tail) return null;
        String ret = items[head];
        ++head;
        return ret;
    }

    public void printAll() {
        for (int i = head; i < tail; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}
