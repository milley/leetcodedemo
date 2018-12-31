package com.milley.structure.array;

/**
 * 1) 数组的插入、删除、按照下标随机访问操作
 * 2) 数组中的数据是int类型
 */
public class ArrayOperator {
    // The array to save int numbers
    public int data[];
    // The capacity of array
    public int n;
    // The length of array
    public int count;

    public ArrayOperator(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }
        return data[index];
    }

    public boolean insert(int index, int value) {
        if (count == n) {
            System.out.println("The array is full");
            return false;
        }
        if (index < 0 || index > count) {
            System.out.printf("The index %d is error\n", index);
            return false;
        }

        for (int i = count; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = value;
        ++count;
        return true;
    }

    public boolean delete(int index) {
        if (index < 0 || index >= count) {
            System.out.printf("The index %d is error\n", index);
            return false;
        }

        for (int i = index; i < n - 1; i++) {
            data[i] = data[i + 1];
        }
        --count;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("\n");
    }
}
