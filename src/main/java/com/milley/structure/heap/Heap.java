package com.milley.structure.heap;

public class Heap {
    private int[] a;        // 数组，从下标1开始
    private int n;          // 堆可以存储的最大数据个数
    private int count;      // 堆中已经存储的数据个数

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public void insert(int data) {
        if (count >= n) return;
        ++count;
        a[count] = data;
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) {  // 自下往上堆化
            int tmp = a[i / 2];
            a[i / 2] = a[i];
            a[i] = tmp;
            i = i / 2;
        }
    }

    public void removeMax() {
        if (count == 0) return;     // 堆中无数据
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
    }

    private void heapify(int[] a, int n, int i) {       // 自上而下堆化
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) break;
            int tmp = a[i];
            a[i] = a[maxPos];
            a[maxPos] = tmp;
            i = maxPos;
        }
    }

    private void buildHeap(int[] a, int n) {
        for (int i = n / 2; i >= 1; --i) {
            heapify(a, n, i);
        }
    }

    public void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            int tmp = a[1];
            a[1] = a[k];
            a[k] = tmp;
            --k;
            heapify(a, k, 1);
        }
    }
}
